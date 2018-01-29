package com.zeus.rcode.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zeus.rcode.models.Answer;
import com.zeus.rcode.repositories.AnswerRepository;

@Service
public class AnswerServices {
	
	private AnswerRepository answerRepository;
	public AnswerServices(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public ArrayList<Answer> getAll(){
		return answerRepository.findAll();
	}
	
	public Answer findAnswer(Long id) {
		return answerRepository.findOne(id);
	}
	
	public void addAnswer(Answer answer) {
		answerRepository.save(answer);
	}
	public void deleteAnswer(Long id) {
		answerRepository.delete(id);
	}

}
