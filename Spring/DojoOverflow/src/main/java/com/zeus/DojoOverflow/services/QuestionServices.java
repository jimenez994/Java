package com.zeus.DojoOverflow.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zeus.DojoOverflow.models.Question;
import com.zeus.DojoOverflow.repositories.QuestionRepo;

@Service
public class QuestionServices {
	
	private QuestionRepo questionRepo;
	
	public QuestionServices (QuestionRepo questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	public ArrayList<Question> getAll(){
		return questionRepo.findAll();
	}
	
	public Question findQuestion(Long id) {
		return questionRepo.findOne(id);
	}
	
	public void addQuestion(Question question) {
		questionRepo.save(question);
	}
}
