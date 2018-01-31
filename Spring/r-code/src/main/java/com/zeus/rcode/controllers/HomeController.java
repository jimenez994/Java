package com.zeus.rcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.rcode.services.PostServices;
import com.zeus.rcode.services.UserServices;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired 
	private UserServices userServices; 
	
	@Autowired
	private PostServices postServices;
	
	
	@RequestMapping("")
	public String home() {
		return "home";
	}

}
