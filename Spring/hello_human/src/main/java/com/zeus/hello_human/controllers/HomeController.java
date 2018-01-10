package com.zeus.hello_human.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String index(){
		return "index.jsp"; 
	}
	@RequestMapping("/name")
	public String name(@RequestParam(value="q", required=false) String searchQuery, Model model ){
		model.addAttribute("name", searchQuery);
		System.out.println(searchQuery);
		return "name.jsp"; 
	}

}
