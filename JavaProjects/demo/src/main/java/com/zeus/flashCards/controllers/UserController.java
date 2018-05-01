package com.zeus.flashCards.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.flashCards.models.User;
import com.zeus.flashCards.services.CardServices;
import com.zeus.flashCards.services.DeckServices;
import com.zeus.flashCards.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired 
	private CardServices cardServices;
	@Autowired 
	private DeckServices deckServices;
	@Autowired 
	private UserServices userServices;
	
	@GetMapping("allUsers")
	public ArrayList<User> all(){
		return userServices.all();
	}
	
	@PostMapping("new")
	public String createUser(@RequestBody User user) {
		System.out.println(user);
		return userServices.create(user);
	}
}
