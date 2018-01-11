package com.zeus.ninja_gold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

@RequestMapping("/")
public class HomeController {
	 
	    ArrayList<String> inner = new ArrayList<String>();
	    
	
	@RequestMapping("")
	public String index(HttpSession session) {
		Collections.reverse(inner);
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		session.setAttribute("goldlist", inner);
		
		return "index.jsp";
	}
	
	@RequestMapping(path="/process_gold/farm", method=RequestMethod.POST)
	public String farm(HttpSession session) {
		Collections.reverse(inner);
		Random r = new Random();
		int Low = 10;
		int High = 20;
		int result = r.nextInt(High-Low) + Low;
		SimpleDateFormat date= new SimpleDateFormat("EEEE, 'the' d 'of' MMM , yyyy hh:mm a");
		Date now = new Date();
		String message = "Earn "+result + " on a farm "+date.format(now);
		inner.add(message);
		session.setAttribute("gold",(Integer) session.getAttribute("gold")+result);
		return "redirect:/";	
	}
	
	@RequestMapping(path="/process_gold/cave", method=RequestMethod.POST)
	public String cave(HttpSession session) {
		Collections.reverse(inner);
		Random r = new Random();
		int Low = 5;
		int High = 10;
		int result = r.nextInt(High-Low) + Low;
		SimpleDateFormat date= new SimpleDateFormat("EEEE, 'the' d 'of' MMM , yyyy hh:mm a");
		Date now = new Date();
		String message = "Earn "+result + " on a cave "+date.format(now) ;
		inner.add(message);
		session.setAttribute("gold",(Integer) session.getAttribute("gold")+result);
		return "redirect:/";
	}
	
	@RequestMapping(path="/process_gold/house", method=RequestMethod.POST)
	public String house(HttpSession session) {
		Collections.reverse(inner);
		Random r = new Random();
		int Low = 2;
		int High = 5;
		int result = r.nextInt(High-Low) + Low;
		SimpleDateFormat date= new SimpleDateFormat("EEEE, 'the' d 'of' MMM , yyyy hh:mm a");
		Date now = new Date();
		String message = "Earn "+result + " at the house "+date.format(now);
		inner.add(message);
		session.setAttribute("gold",(Integer) session.getAttribute("gold")+result);
		return "redirect:/";
	}
	
	@RequestMapping(path="/process_gold/casino", method=RequestMethod.POST)
	public String casino(HttpSession session) {
		Collections.reverse(inner);
		Random r = new Random();
		int Low = -50;
		int High = 50;
		int result = r.nextInt(High-Low) + Low;
		SimpleDateFormat date= new SimpleDateFormat("EEEE, 'the' d 'of' MMM , yyyy , yyyy hh:mm a");
		Date now = new Date();
		session.setAttribute("gold",(Integer) session.getAttribute("gold")+result);
		if(result < 0) {
			inner.add("Lost "+ Math.abs(result) + " on a casino "+ date.format(now));
		}else {
			inner.add("Earn "+result + " on a casino "+ date.format(now));
		}		
		
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate() ;
		inner.clear();
		return "redirect:/";
	}
	
	
	

}
