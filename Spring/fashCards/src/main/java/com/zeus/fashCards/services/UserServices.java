package com.zeus.fashCards.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.fashCards.models.User;
import com.zeus.fashCards.repositories.UserRepository;

@Service
public class UserServices {
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAll(){
		List<User> list = userRepo.findAll();
		Collections.reverse(list);
		return list;
	}
	public void addUser(User user) {
		userRepo.save(user);
	}
}
