package com.zeus.rcode.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.rcode.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{
	ArrayList<Answer> findAll();

}
