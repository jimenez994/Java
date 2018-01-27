package com.zeus.loginRS.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zeus.loginRS.models.Pack;
import com.zeus.loginRS.repositories.PackRepository;

@Service
public class PackServices {
	private PackRepository packRepo;
	public PackServices(PackRepository packRepo) {
		this.packRepo = packRepo;
	}

	public ArrayList<Pack> getAll(){
		return packRepo.findAll();
	}
	public ArrayList<Pack> getAllActive(){
		ArrayList<Pack> all = packRepo.findAll();
		 ArrayList<Pack> newList = new ArrayList<Pack>();
		for(int i = 0; i<all.size();i++) {
			if(all.get(i).isActivation() == true) {
				newList.add(all.get(i));
			}
		}
		return newList;
	}
	
	public Pack getPack(Long id) {
		return packRepo.findOne(id);
	}
	public void addPack(Pack pack) {
		packRepo.save(pack);
	}
	public void activate(Long id) {
		Pack pack = getPack(id);
		if(pack.isActivation() == false) {
			pack.setActivation(true);
			addPack(pack);
		}
	}
	public void deactivate(Long id) {
		Pack pack = getPack(id);
		if(pack.isActivation() == true) {
			pack.setActivation(false);
			addPack(pack);
		}
	}
	public void delete(Long id) {
		packRepo.delete(id);
	}
	
}
