package com.zeus.loginRS.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zeus.loginRS.models.DueDate;
import com.zeus.loginRS.repositories.DueDateRepository;


@Service
public class DueDateServices {

	private DueDateRepository dueDateRepo;
	public DueDateServices(DueDateRepository dueDateRepo) {
		this.dueDateRepo = dueDateRepo;
	}

	public ArrayList<DueDate> getAll(){
		return dueDateRepo.findAll();
	}
	public DueDate getDueDate(Long id) {
		return dueDateRepo.findOne(id);
	}
	public void addPack(DueDate dueDate) {
		dueDateRepo.save(dueDate);
	}
}
