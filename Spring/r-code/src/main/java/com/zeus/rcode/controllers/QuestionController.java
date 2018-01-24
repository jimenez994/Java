package com.zeus.rcode.controllers;

import org.springframework.stereotype.Controller;

import com.zeus.rcode.services.QuestionServices;

@Controller

public class QuestionController {
	
	public QuestionServices questionServices;
	public QuestionController(QuestionServices questionServices) {
		this.questionServices = questionServices;
	}
	
//	@RequestMapping("/dashboard")
//	public String createQuestion() {
//		return "dashboard";
//	}
//	

}
