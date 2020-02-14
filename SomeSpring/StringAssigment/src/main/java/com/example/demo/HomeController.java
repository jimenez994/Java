package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping("")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value ="/cool", method= RequestMethod.GET)
	public String cool() {
		return "index.jsp";
	}
	
	@RequestMapping("/search")
	public String cool(@RequestParam(value = "something", required=false) String search) {
		System.out.print(search);
		return search;
	}
	
	@RequestMapping("/java")
	public String java() {
		return "hi java";
	}
	@RequestMapping("/python")
	public String pythn() {
		return "this is python";
	}
	@RequestMapping("/react")
	public String react() {
		return "some react";
	}

}
