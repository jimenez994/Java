package com.zeus.DojosAndNinjas.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zeus.DojosAndNinjas.models.Dojo;
import com.zeus.DojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoServices {
	private DojoRepository dojoRepository;
	
	public DojoServices(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public ArrayList<Dojo> getAll(){
		return dojoRepository.findAll();
	}
	public Dojo getDojo(Long id) {
		return dojoRepository.findOne(id);
	}
	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	

}
