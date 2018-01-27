package com.zeus.loginRS.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.loginRS.models.Pack;
import com.zeus.loginRS.models.User;
import com.zeus.loginRS.services.PackServices;
import com.zeus.loginRS.services.UserServices;

@Controller
public class AdminDashboardController {
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private PackServices packServices;
	
	@RequestMapping("/adminDashboard")
	public String admindash(Model model,HttpSession session,@ModelAttribute("newPackage")Pack pack) {
		ArrayList <Pack> packs = packServices.getAll();
		ArrayList <User> users = userServices.all();
		model.addAttribute("packs", packs);
		model.addAttribute("users", users);
		return "adminDashboard";
	}
	
	@PostMapping("/create/package")
	public String createPack(HttpSession session,@Valid @ModelAttribute("newPackage")Pack pack,BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/adminDashBoard";
		}else {
			if((long)session.getAttribute("id")==pack.getUser().getId()) {
				packServices.addPack(pack);
				System.out.println(pack.isActivation());

			}
			System.out.println(pack.getUser().getId());
			return "redirect:/adminDashBoard";
		}
	}
	@RequestMapping("/activate/{id}")
	public String activate(@PathVariable("id") Long id) {
		packServices.activate(id);
		return "redirect:/adminDashBoard";
	}
	@RequestMapping("/deactivate/{id}")
	public String deactivate(@PathVariable("id") Long id) {
		packServices.deactivate(id);
		return "redirect:/adminDashBoard";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		packServices.delete(id);
		return "redirect:/adminDashBoard";
	}
	
	
	
	
	
	
	
	

}
