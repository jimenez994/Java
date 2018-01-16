package com.zeus.DojoOverflow.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zeus.DojoOverflow.models.Answer;
import com.zeus.DojoOverflow.repositories.AnswerRepo;

@Service
public class AnswerServices {

	private AnswerRepo answerRepo;
	public AnswerServices(AnswerRepo answerRepo) {
		this.answerRepo = answerRepo;
	}
	
	public ArrayList<Answer> getAll(){
		return answerRepo.findAll();
	}
	
	public Answer findAnswer(Long id) {
		return answerRepo.findOne(id);
	}
	public void addAnswer(Answer answer) {
		answerRepo.save(answer);
	}
	
}
