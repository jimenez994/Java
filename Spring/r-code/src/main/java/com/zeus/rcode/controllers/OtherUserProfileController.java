package com.zeus.rcode.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.rcode.models.Question;
import com.zeus.rcode.models.User;
import com.zeus.rcode.services.UserServices;

@Controller
@RequestMapping("/profile")
public class OtherUserProfileController {
	
	@Autowired
	private UserServices userServices;
	
	@RequestMapping("/{id}")
	public String viewPrifile(@PathVariable("id") Long id,Model model,HttpSession session) {
		User user = userServices.findById(id);
		User cUser = userServices.findById((long)session.getAttribute("id"));
		List<Question> questions = user.getQuetion();
		PrettyTime prettyTime = new PrettyTime();

		model.addAttribute("cUser", cUser);
		model.addAttribute("user", user);
		model.addAttribute("questions", questions);
		model.addAttribute("pTime", prettyTime);
		return "otherUserProfile";
	}

}
