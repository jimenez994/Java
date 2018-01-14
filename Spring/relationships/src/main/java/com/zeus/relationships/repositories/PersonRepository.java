package com.zeus.relationships.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	ArrayList<Person> findAll();

}
