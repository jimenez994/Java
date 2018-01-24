package com.zeus.rcode.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeus.rcode.models.User;
import com.zeus.rcode.services.QuestionServices;
import com.zeus.rcode.services.UserServices;

@Controller
public class LoginRController {
	
	@Autowired
	private QuestionServices questionServices;

	private UserServices us;

	public LoginRController(UserServices us){
		this.us=us;
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession session){
		User user = us.findByEmail(email);
		if(user == null) {
			 user = us.findByUsername(email);
		}
		if( user == null ){
			return "redirect:/";
		}else{
			if( us.isMatch( password ,user.getPassword() ) ){
				session.setAttribute("id",user.getId());
				return "redirect:/dashboard";
			}else{
				return "redirect:/";
			}
		}	
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.setAttribute("id",null);
		return "redirect:/";
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute("user") User user,HttpSession session){
		session.setAttribute("id",null);
		return "registerW";
	}

	@PostMapping("/register")
	public String create(@Valid @ModelAttribute("user") User user,BindingResult result,HttpSession session){
		if(result.hasErrors()){
			return "registerW";
		}else{
			if(us.findByEmail(user.getEmail()) == null && us.findByUsername(user.getUsername()) == null) {
				us.create(user);
				session.setAttribute( "id",user.getId() );
				return "redirect:/";
			}else {
				return "redirect:/register";
			}
			
		}
	}
}