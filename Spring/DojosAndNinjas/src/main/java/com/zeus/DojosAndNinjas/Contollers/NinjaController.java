package com.zeus.DojosAndNinjas.Contollers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.DojosAndNinjas.models.Ninja;
import com.zeus.DojosAndNinjas.services.DojoServices;
import com.zeus.DojosAndNinjas.services.NinjaServices;

@Controller
@RequestMapping("/ninja")
public class NinjaController {
	
	private NinjaServices ninjaServices;
	public NinjaController(NinjaServices ninjaServices) {
		this.ninjaServices = ninjaServices;
	}
	
	@Autowired
	private DojoServices dojoServices;
	
	
	@RequestMapping("/new")
	public String createNinja(Model model) {
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("dojo", dojoServices.getAll());
		return "newNinja.jsp";
	}
	@PostMapping("/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja,BindingResult result, RedirectAttributes result2) {
		if(result.hasErrors()) {
			result2.addAttribute("errors", result.getAllErrors());
			return "redirect:/new";
		}else {
			ninjaServices.addNinja(ninja);
			return "redirect:/";
		}
	}
	

}
