package com.zeus.DojosAndNinjas.Contollers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax class="keyword operator from-rainbow">- 1.
	    Page<Ninja> ninjas = ninjaServices.ninjasPerPage(pageNumber - 1);
	    // total number of pages that we have
	    int totalPages = ninjas.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("ninjas", ninjas);
	    return "ninjas.jsp";
	}
//	@RequestMapping("/pages2/{pageNumber}")
//	public String getNinjasAndDojoPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
//	    // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax class="keyword operator from-rainbow">- 1.
//	    Page<Object[]> ninjas = ninjaServices.ninjasAndDojoPerPage(pageNumber - 1);
//	    // total number of pages that we have
//	    int totalPages = ninjas.getTotalPages();
//	    model.addAttribute("totalPages", totalPages);
//	    model.addAttribute("ninjas", ninjas);
//	    return "ninjasAndDojo.jsp";
//	}

	

}
