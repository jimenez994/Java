package com.zeus.DojoOverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.DojoOverflow.services.AnswerServices;
import com.zeus.DojoOverflow.services.QuestionServices;
import com.zeus.DojoOverflow.services.TagServices;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private QuestionServices questionServices;
	
	@Autowired
	private AnswerServices answerServices;
	
	@Autowired
	private TagServices tagServices;
	
	
	
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/questions")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String createQuestion() {
		return "newQuestion.jsp";
	}
	
	

}
