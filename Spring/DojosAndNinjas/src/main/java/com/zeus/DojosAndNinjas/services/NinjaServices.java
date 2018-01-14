package com.zeus.DojosAndNinjas.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zeus.DojosAndNinjas.models.Ninja;
import com.zeus.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaServices {
	private NinjaRepository ninjaRepository;
	public NinjaServices(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	public ArrayList<Ninja> getAll(){
		return (ArrayList<Ninja>) ninjaRepository.findAll();
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
}
