package com.zeus.rcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.rcode.models.Answer;
import com.zeus.rcode.models.Question;
import com.zeus.rcode.services.QuestionServices;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	public QuestionServices questionServices;
	public QuestionController(QuestionServices questionServices) {
		this.questionServices = questionServices;
	}

	
	@RequestMapping("/{id}")
	public String showQuestion(Model model,@PathVariable("id") Long id,@ModelAttribute("newAnswer") Answer answer) {
		Question question = questionServices.getQuestion(id);
		model.addAttribute("question", question);
		return "question";
	}
	
	

}
