package com.zeus.loginRS.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.loginRS.models.User;
import com.zeus.loginRS.services.UserServices;

@Controller
@RequestMapping("/**") // Wildcard all routes.
public class Router{
	
	@Autowired
	private UserServices us;
	public Router(){

	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req,HttpSession session){		
		String url = req.getRequestURI().toString();

		if(session.getAttribute("id") != null){
			return "redirect:/dashboard";
		}else{
			
			return "redirect:/register";
			
		}

	}	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes flashR,HttpSession s){
		User user = us.findByEmail(email);
		
		if( user == null ){
			flashR.addFlashAttribute("error", "Invalid credentials.");
			return "redirect:/register";
		}
		if( us.isMatch( password ,user.getPassword() ) ){
			s.setAttribute("id",user.getId());
			return "redirect:/dashboard";
		}
		flashR.addFlashAttribute("error", "Invalid credentials.");
			s.invalidate();
			return "redirect:/register";
		}
		
	
	
	
	
	
	
	
	
	
	
}