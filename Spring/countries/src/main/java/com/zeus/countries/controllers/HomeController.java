package com.zeus.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.countries.services.CountryServices;

@Controller
@RequestMapping("")
public class HomeController {
	
	private CountryServices countryServices;
	public HomeController(CountryServices countryServices) {
		this.countryServices = countryServices;
	}
	@RequestMapping("/")
	public String index(Model model) {
//		task1
		List<Object[]> task1 = countryServices.getTask1("Slovene");
		model.addAttribute("task1", task1);
//		task2
		List<Object[]> task2 = countryServices.getTask2();
		model.addAttribute("task2", task2);
//		task3
		List<Object[]> task3 = countryServices.getTask3();
		model.addAttribute("task3", task3);
//		task4
		List<Object[]> task4 = countryServices.getTask4();
		model.addAttribute("task4", task4);
//		task5
		List<Object[]> task5 = countryServices.getTask5();
		model.addAttribute("task5", task5);
//		task6
		List<Object[]> task6 = countryServices.getTask6();
		model.addAttribute("task6", task6);
//		task7
		List<Object[]> task7 = countryServices.getTask7();
		model.addAttribute("task7", task7);
//		task8
		List<Object[]> task8 = countryServices.getTask8();
		model.addAttribute("task8", task8);

		System.out.println(task7);
		return "index.jsp";
	}

}
