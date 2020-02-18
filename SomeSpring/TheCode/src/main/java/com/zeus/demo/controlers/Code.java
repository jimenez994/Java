package com.zeus.demo.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Code {
	
	@RequestMapping("/")
	public String theCode() {
		return "index";
	}
	
	@RequestMapping("/success")
	public String message() {
		return "message";
	}
	
	@PostMapping("/submit")
	public String checkCode(@RequestParam(value="input") String inputCode,RedirectAttributes redirectAttributes) {
		System.out.println(inputCode);
		if(inputCode.equals("bushido")) {
			return "redirect:/success";
		}else {
			redirectAttributes.addFlashAttribute("error", "Invalid Code");
			return "redirect:/";
		}
	}

}
