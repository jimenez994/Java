package com.zeus.rcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.rcode.services.UserServices;

@Controller
@RequestMapping("/user")
public class ProfileController {
	
	@Autowired
	private UserServices userServices;
	
	@RequestMapping("/{id}")
	public String profile() {
		return "profile";
	}
	

}
