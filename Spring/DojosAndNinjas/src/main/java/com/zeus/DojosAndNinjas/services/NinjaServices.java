package com.zeus.DojosAndNinjas.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zeus.DojosAndNinjas.models.Ninja;
import com.zeus.DojosAndNinjas.repositories.NinjaRepository;

@Service
@Transactional

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
	
    // static variable to set the number of ninjas that we want per page
    private static final int PAGE_SIZE = 5; 
    public Page<Ninja> ninjasPerPage(int pageNumber) {
        // get all the ninjas page and sort them in ascending order the last name property
        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "lastName");
        Page<Ninja> ninjas = ninjaRepository.findAll(pageRequest);
        return ninjaRepository.findAll(pageRequest);
    }
}
