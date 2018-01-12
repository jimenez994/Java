package com.zeus.group_languages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zeus.group_languages.models.Crud;

@Service
public class LanguageService {
	List<Crud> languages = new ArrayList<Crud>(Arrays.asList(
			new Crud("Java","James Gosling","1.8")
			));
	public List<Crud> allLanguages(){
		return languages;
	}
	public Crud findlLanguageBYIndex(int index) {
		if(index < languages.size()) {
			return languages.get(index);
		}else {
			return null;
		}
	}
	public void addLanguage(Crud language) {
		languages.add(language);
	}
	public void updateLanguage(int id, Crud language) {
		if(id < languages.size()) {
			languages.set(id, language);
		}
	}
	public void destroyLanguage(int id) {
		if (id< languages.size()) {
			languages.remove(id);
		}
	}

}
