package com.zeus.group_languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.group_languages.models.Crud;
import com.zeus.group_languages.services.LanguageService;

@Controller
@RequestMapping("/")
public class HomeController {

	private final LanguageService  languageService;
	public HomeController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping("")
	public String index(Model model,@ModelAttribute("language")Crud language) {
		List<Crud> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}

	@RequestMapping("/language/{id}")
	public String Language(@PathVariable("id") Long id, Model model) {
		Crud language= languageService.findLanguageById(id);
		if (language != null) {
			model.addAttribute("language",language);
			return "language.jsp";
		}else {
			return "redirect:/";
		}
	}

	@PostMapping("/language/new")
	public String createLanguage(@Valid @ModelAttribute("language") Crud language, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Crud> languages = languageService.allLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}else {
			languageService.addLanguage(language);
			return "redirect:/";
		}
	}

	@RequestMapping("/language/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, Model model) {
		Crud language= languageService.findLanguageById(id);
		if (language != null) {
			model.addAttribute("language",language);
			return "editLanguage.jsp";
		}else {
			return "redirect:/";
		}
	}
	@PostMapping(value="/language/update/{id}")
	public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Crud language, BindingResult result) {
		if (result.hasErrors()) {
				return "redirect:/language/edit/{id}";
		}else {
			languageService.updateLanguage(language);
			return "redirect:/";
		}
	}
	@RequestMapping(value="/language/delete/{id}")
	public String destroyLanguage(@PathVariable("id") Long id ) {
		languageService.destroyLanguage(id);
		return"redirect:/";
	}





}
