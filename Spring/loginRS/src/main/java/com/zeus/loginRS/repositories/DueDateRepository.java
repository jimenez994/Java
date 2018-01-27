package com.zeus.loginRS.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.loginRS.models.DueDate;

@Repository
public interface DueDateRepository extends CrudRepository<DueDate , Long>{
	ArrayList<DueDate> findAll();

}
