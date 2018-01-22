package com.zeus.Events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zeus.Events.models.JoinUE;
import com.zeus.Events.repositories.JoinUERepository;

@Service
public class JoinUEServices {

	private JoinUERepository joinUERepository;
	public JoinUEServices(JoinUERepository joinUERepository) {
		this.joinUERepository = joinUERepository;
	}
	public List<JoinUE> getAll(){
		return joinUERepository.findAll();
	}
	public void addJoin(JoinUE joinUE) {
		joinUERepository.save(joinUE);
	}
	public void deleteJoin(Long id) {
		joinUERepository.delete(id);
	}
}
