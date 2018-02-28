package com.zeus.rcode.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.rcode.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{
	ArrayList<Question> findAll();

}
