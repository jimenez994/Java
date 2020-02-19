package com.zeus.survey.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SurveyController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@PostMapping("/subSurvey")
	public String submit(RedirectAttributes redirectAttributes,@RequestParam("name") String name, @RequestParam("location") String location,@RequestParam("language") String language, @RequestParam("comment") String comment) {
        redirectAttributes.addFlashAttribute("name", name);
        redirectAttributes.addFlashAttribute("location", location);
        redirectAttributes.addFlashAttribute("language", language);
        redirectAttributes.addFlashAttribute("comment", comment);
		return "redirect:/result";
		
	}
	
	@RequestMapping("/result")
	public String result() {
		return "result";
	}

}
