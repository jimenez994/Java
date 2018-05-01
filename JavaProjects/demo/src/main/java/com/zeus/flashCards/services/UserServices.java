package com.zeus.flashCards.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zeus.flashCards.models.User;
import com.zeus.flashCards.repositories.UserRepository;

@Service
public class UserServices {
	
	@Autowired 
	private UserRepository userRepo;	
	private BCryptPasswordEncoder bcrypt;
	
	public UserServices(UserRepository userRepo) {
		this.userRepo = userRepo;
		this.bcrypt=new BCryptPasswordEncoder();
	}
	public boolean isMatch(String password,String dbPass){
		if( bcrypt.matches(password,dbPass) ){
			return true;
		}else{
			return false;
		}
	}

	public String create(User user){
		System.out.println(user.getEmail());
		if (userRepo.findByEmail(user.getEmail()) != null) {
			return "Email is already taken";
		}else if (userRepo.findByUsername(user.getUsername()) != null) {
			return "Username is already in use";
		}else {
			user.setPassword(  bcrypt.encode( user.getPassword() ) );
			userRepo.save(user);
			return "You created a new User";
		}
	}

	public void update(User user){
		userRepo.save(user);
	}
	public ArrayList<User> all(){
		return userRepo.findAll();
	}

	public User findById(long id){
		return userRepo.findOne(id);
	}

	public void destroy(User user){
		userRepo.delete(user);
	}

	public User findByEmail(String email){
		return (User) userRepo.findByEmail(email);
	}
	public User findByUsername(String username){
		return (User) userRepo.findByUsername(username);
	}

	
}
