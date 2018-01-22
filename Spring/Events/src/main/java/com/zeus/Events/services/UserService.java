package com.zeus.Events.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zeus.Events.models.User;
import com.zeus.Events.repositories.RoleRepository;
import com.zeus.Events.repositories.UserRepository;


@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public List<User> getAllUsers(){
    		return (List<User>) userRepository.findAll();
    }
    
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
    
//    1.5
    public String saveNoDuplicate(User user) {
    		List<User> emails = (List<User>) userRepository.findAll();
    		for(int i=0; i<=emails.size()-1;i++) {
    			if(emails.get(i).getEmail().equals(user.getEmail())) {
    				return "Sorry that email address is already used";
    			}
    		}
    		if(emails.size() < 0) {
    			saveUserWithAdminRole(user);
    			return "You successfully register ADMIN, you may now login";
    		}
    		saveWithUserRole(user);
    		return "You successfully register! You can now Login";
    }
   
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String email) {
        return userRepository.findByEmail(email);
    }
    
    public void deleteUser(Long id) {
    		userRepository.delete(id);
    }
    public User findUserById(Long id) {
    		return userRepository.findOne(id);
    }
    public void upgradeUser(User user) {
    	System.out.println("**************");
    	
    		user.getRoles().clear();
    		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
    		userRepository.save(user);
    		
    }
}