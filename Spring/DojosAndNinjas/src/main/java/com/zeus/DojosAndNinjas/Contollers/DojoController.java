package com.zeus.DojosAndNinjas.Contollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.DojosAndNinjas.models.Dojo;
import com.zeus.DojosAndNinjas.models.Ninja;
import com.zeus.DojosAndNinjas.services.DojoServices;

@Controller
@RequestMapping("/dojo")
public class DojoController {
	
	private DojoServices dojoServices;
	public DojoController(DojoServices dojoServices) {
		this.dojoServices = dojoServices;
	}

	
	@RequestMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	@PostMapping("/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}else {
			dojoServices.addDojo(dojo);
			return "redirect:/";
		}
	}
	@RequestMapping("/{id}")
	public String selectedDojo(Model model,@PathVariable("id") Long id) {
		List<Ninja> ninjas = dojoServices.getDojo(id).getNinjas();
		model.addAttribute("dojo", dojoServices.getDojo(id));
		model.addAttribute("ninjas", ninjas);
		return "showDojosNinjas.jsp";
	}
	

}
