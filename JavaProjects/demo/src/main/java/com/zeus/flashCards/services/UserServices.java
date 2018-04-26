package com.zeus.flashCards.services;

import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zeus.flashCards.models.User;
import com.zeus.flashCards.repositories.UserRepository;

@Service
public class UserServices {
	
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

	public void create(User user){
		user.setPassword(  bcrypt.encode( user.getPassword() ) );
		userRepo.save(user);
	}

	public void update(User user){
		userRepo.save(user);
	}
	public ArrayList<User> all(){
		return (ArrayList<User>)userRepo.findAll();
	}

	public User findById(long id){
		return (User) userRepo.findOne(id);
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
