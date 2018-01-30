package com.zeus.rcode.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.rcode.models.User;
import com.zeus.rcode.models.UserInfo;
import com.zeus.rcode.services.UserInfoServices;
import com.zeus.rcode.services.UserServices;

@Controller
@RequestMapping("/user")
public class ProfileController {
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private UserInfoServices userInfoServices;
	
	@RequestMapping("/{id}")
	public String profile(Model model,HttpSession session) {
		
		User cUser = userServices.findById((long)session.getAttribute("id"));
		UserInfo cUserInfo = cUser.getUserInfo();
		if(cUser.getUserInfo() != null) {
			model.addAttribute("updateUserInfo",cUserInfo);
		}else {
			model.addAttribute("updateUserInfo",new UserInfo());
		}
		
		model.addAttribute("cUser", cUser);
		return "profile";
	
	}
	
	@PostMapping("/update/profile")
	public String saveUpdate(HttpSession session,@Valid @ModelAttribute("updateUserInfo") UserInfo userInfo,BindingResult result) {
		User cUser = userServices.findById((long)session.getAttribute("id"));
		System.out.println(userInfo.getId()+"*************");
		if(result.hasErrors()) {
			return "redirect:/user/"+cUser.getId();
		}else {
			userInfo.setId(null);
			if(cUser.getUserInfo() != null) {
				userInfo.setId(cUser.getUserInfo().getId());

			}
			userInfo.setUser(cUser);
			userInfoServices.addUserInfo(userInfo);
			System.out.println("1-*****");
			
			
			return "redirect:/user/"+cUser.getId();
		}
		
	}
	

}
