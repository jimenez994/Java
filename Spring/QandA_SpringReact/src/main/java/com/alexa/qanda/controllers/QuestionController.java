package com.alexa.qanda.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alexa.qanda.models.Question;
import com.alexa.qanda.repositories.QuestionRepository;

@Controller
@RequestMapping("/api/questions")
public class QuestionController {
	private QuestionRepository qR;
	
	public QuestionController(QuestionRepository qR) {
		this.qR = qR;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("")
	@ResponseBody
	public ArrayList<Question> questions() {
		return (ArrayList<Question>) qR.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/new")
	@ResponseBody
	public Question create(@Valid @ModelAttribute("question") Question question, BindingResult res) {
		
		if(res.hasErrors()) {
			System.out.println(res.getAllErrors());
			return question;
		}
		
		qR.save(question);
		return question;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/{id}")
	@ResponseBody
	public Question find(@PathVariable("id") Long questionId) {
		Question q = qR.findOne(questionId);
		if (qR == null) {
			return null;
		} else {
			return q;
		}
	}
}
