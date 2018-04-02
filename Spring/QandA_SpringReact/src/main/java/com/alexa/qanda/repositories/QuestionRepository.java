package com.alexa.qanda.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexa.qanda.models.Question;
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

}
