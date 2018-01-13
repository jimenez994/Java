package com.zeus.group_languages.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zeus.group_languages.models.Crud;
import com.zeus.group_languages.repositories.groupLanguageRepository;

@Service
public class LanguageService {
	private groupLanguageRepository groupLanguageRepository;
	public LanguageService(groupLanguageRepository groupLanguageRepository) {
		this.groupLanguageRepository = groupLanguageRepository;
	}
	
	public ArrayList<Crud> allLanguages(){
		return (ArrayList<Crud>) groupLanguageRepository.findAll();
	}
	public void addLanguage(Crud language) {
		groupLanguageRepository.save(language);
	}
	public void destroyLanguage(Long id) {
		groupLanguageRepository.delete(id);
	}
	
	public Crud findLanguageById(Long id) {
		return groupLanguageRepository.findOne(id);
	}
	public void updateLanguag(Crud language) {
		groupLanguageRepository.save(language);
	}
	
	


}
