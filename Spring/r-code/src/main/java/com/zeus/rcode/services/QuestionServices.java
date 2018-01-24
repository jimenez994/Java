package com.zeus.rcode.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zeus.rcode.models.Question;
import com.zeus.rcode.repositories.QuestionRepository;

@Service
public class QuestionServices {
	private QuestionRepository questionRepo;
	
	public QuestionServices(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	public List<Question> getAll(){
		return questionRepo.findAll();
	}
	public Question getQuestion(Long id) {
		return questionRepo.findOne(id);
	}
	public void  addQuestion(Question question) {
		questionRepo.save(question);
	}
	public void updateQuestion(Question question) {
		questionRepo.save(question);
	}
	public void deleteQuestion(Long id) {
		questionRepo.delete(id);
	}

}
