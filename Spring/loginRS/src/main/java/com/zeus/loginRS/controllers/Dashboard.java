package com.zeus.loginRS.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeus.loginRS.models.DueDate;
import com.zeus.loginRS.models.Pack;
import com.zeus.loginRS.models.User;
import com.zeus.loginRS.services.DueDateServices;
import com.zeus.loginRS.services.PackServices;
import com.zeus.loginRS.services.UserServices;

@Controller
public class Dashboard {
	
	@Autowired 
	private UserServices userServices;
	
	@Autowired
	private PackServices packServices;
	
	@Autowired
	private DueDateServices dueDateServices;
	
	@RequestMapping("/selection")
	public String selection(HttpSession session,Model model) {
		System.out.println("Zeus");
		ArrayList<Pack> packs = packServices.getAllActive();
		
		User cUser = userServices.findById((long)session.getAttribute("id"));
		model.addAttribute("cUser", cUser);
		model.addAttribute("packs", packs);
		return"dashboard";
	}
	@PostMapping("/subscribe")
	public String subscribing(HttpSession session,@RequestParam("num") int dueDate,@RequestParam("pack") long packId) {
		User cUser = userServices.findById((long)session.getAttribute("id"));
		if(dueDate==31) {
		dueDate = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		DueDate newDueDate = new DueDate(dueDate,cUser);
		dueDateServices.addPack(newDueDate);
		cUser.setPack(packServices.getPack(packId));
		userServices.update(cUser);
		System.out.println(dueDate+"this is a duedate");
		System.out.println(packId+"this is a pack id");

		return"redirect:/profile";
	}
	@RequestMapping("/profile")
	public String profile(Model model,HttpSession session) {
		User cUser = userServices.findById((long)session.getAttribute("id"));
		DueDate dueS = cUser.getDueDate();
	
		String pattern = "MMMMMM dd, yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(cUser.getCreatedAt());
	
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
		LocalDateTime now = LocalDateTime.now();
		Date nowDateW = new Date();
		int nowDate = Integer.parseInt(dtf.format(now).toString());
		int dueDate = cUser.getDueDate().getDue();
		
		if(nowDate >= dueDate) {
			System.out.println(dueDate);
			if(dueDate==31) {
				Calendar c = Calendar.getInstance();
				c.setTime(nowDateW);
				c.add(Calendar.MONTH, 1);
				int last = c.getActualMaximum(Calendar.DATE);
				dueDate = last;
				}
			LocalDate fDate = LocalDate.now().plusMonths(1);
			Date futureDate = Date.from(fDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			String patternF = "MMMMMM ";
			SimpleDateFormat simpleDateFormatF = new SimpleDateFormat(patternF);
			String dateF = simpleDateFormatF.format(futureDate);
			String dDate = dateF+" "+dueDate;
			dueS.setMonth(dDate);
			dueDateServices.addPack(dueS);
			model.addAttribute("dDate", dDate);
			
		}else {
			if(dueDate==31) {
				Calendar c = Calendar.getInstance();
				c.setTime(nowDateW);
				int last = c.getActualMaximum(Calendar.DATE);
				dueDate = last;
				}
			Date date2 = new Date();
			String patternNow = "MMMMMM ";
			SimpleDateFormat simpleDateFormatNow = new SimpleDateFormat(patternNow);
			String dateNow = simpleDateFormatNow.format(date2);
			String dDate = dateNow+" "+dueDate;
			System.out.println("JJ");
			dueS.setMonth(dDate);
			dueDateServices.addPack(dueS);
			model.addAttribute("dDate", dDate);
		}
		
		
		model.addAttribute("since", date);

		model.addAttribute("pack", cUser.getPack());
		model.addAttribute("cUser", cUser);
		return"profile";
	}

}
