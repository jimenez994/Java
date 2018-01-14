package com.zeus.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.relationships.models.License;
import com.zeus.relationships.models.Person;
import com.zeus.relationships.services.LicenseService;
import com.zeus.relationships.services.PersonService;

@Controller
@RequestMapping("/")
public class RelationshipControllers {
	
	private PersonService personService;
	private LicenseService licenseService;
	
	public RelationshipControllers(PersonService personService, LicenseService licenseService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {	
		return "new.jsp";
	}
	@PostMapping("/person/new")
	public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			personService.addPerson(person);
			return "redirect:/license/new";
		}
	}
	@RequestMapping("/license/new")
	public String newLicense(Model model) {
		model.addAttribute("license",new License());
		model.addAttribute("people", personService.noLicense());
		return "newLicense.jsp";
	}
	@PostMapping("/license/new")
	public String create(@Valid @ModelAttribute("license") License license,BindingResult res,RedirectAttributes re){
		
		if(res.hasErrors()){
			System.out.println(res.getAllErrors());
			re.addFlashAttribute("errs",res.getAllErrors());
			return "redirect:/license/new";
		}else{
			licenseService.addLicense(license);
			return "redirect:/";
		}
	}
	
	
	
	
	
	
	
	
	

}
