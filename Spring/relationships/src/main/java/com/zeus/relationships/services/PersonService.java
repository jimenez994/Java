package com.zeus.relationships.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.relationships.models.License;
import com.zeus.relationships.models.Person;
import com.zeus.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private PersonRepository personRepository;
	
	@Autowired
	private LicenseService licenseService;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public ArrayList<Person> getAll(){
		return personRepository.findAll();
	}
	
	public Person getPerson(Long id) {
		return personRepository.findOne(id);
	}
	
	@Transactional
	public void addPerson(Person person) {
		personRepository.save(person);
	}
	
	public ArrayList<Person> noLicense(){
		ArrayList<Person> people = this.getAll();
		ArrayList<License> licenses = licenseService.getAll();
		for(int i=0;i<people.size();i++){
			for(int j=0;j<licenses.size();j++){ 
				if(people.get(i).getId() == licenses.get(j).getPerson().getId()){
					people.remove(i);
				}
			}
		}
		return people; 
	}
	
	

}
