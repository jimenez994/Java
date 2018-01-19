package com.zeus.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zeus.countries.repositories.CountryRepo;

@Service
public class CountryServices {
	private CountryRepo countryRepo;
	public CountryServices(CountryRepo countryRepo) {
		this.countryRepo = countryRepo;
	}
	public List<Object[]> getTask1(String name){
		return countryRepo.task1S(name);
	}
	public List<Object[]> getTask2(){
		return countryRepo.task2S();
	}
	public List<Object[]> getTask3(){
		return countryRepo.task3S();
	}
	public List<Object[]> getTask4(){
		return countryRepo.task4S();
	}
	public List<Object[]> getTask5(){
		return countryRepo.task5S();
	}
	public List<Object[]> getTask6(){
		return countryRepo.task6S();
	}
	public List<Object[]> getTask7(){
		return countryRepo.task7S();
	}
	public List<Object[]> getTask8(){
		return countryRepo.task8S();
	}
	
	

}
