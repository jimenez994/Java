package com.zeus.loginRS.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.loginRS.models.User;
import com.zeus.loginRS.services.UserServices;

@Controller
public class UserController{
	private UserServices us;

	public UserController(UserServices us){
		this.us=us;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(HttpSession s){
		if( s.getAttribute("id") != null ){
			if(us.findById((long)s.getAttribute("id")).getLevel()==1) {
				return "redirect:/adminDashboard";
			}else if(us.findById((long)s.getAttribute("id")).getPack() != null) {
				System.out.println("is working*******");
				return "redirect:/profile";
			}
			return "redirect:/selection";
		}else{
			return "redirect:/";
		}
	}

	
	
	


	@RequestMapping("/logout")
	public String logout(HttpSession s){
		s.setAttribute("id",null);
		return "redirect:/";
	}

	@RequestMapping("/register")
	public String register(RedirectAttributes flasM,@ModelAttribute("user") User user,HttpSession s){
		s.setAttribute("id",null);
		return "register";
	}

	@PostMapping("/register")
	public String create(@Valid @ModelAttribute("user") User user,BindingResult res,HttpSession session){
		if(res.hasErrors()){
			return "register";
		}else{
			if(user.getConfirm().equals(user.getPassword())) {
				us.create(user);
				session.setAttribute( "id",user.getId() );
				return "redirect:/";
			}
			return "register";
		}
	}
}