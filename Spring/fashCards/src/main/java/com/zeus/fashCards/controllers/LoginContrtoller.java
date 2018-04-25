package com.zeus.fashCards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeus.fashCards.services.UserServices;

@Controller
public class LoginContrtoller {
	@Autowired
	private UserServices userS;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@PostMapping("/newQuestions")
	public String addUser(@RequestParam("username") String username) {
		System.out.println(username);
		return "index";
	}
}
