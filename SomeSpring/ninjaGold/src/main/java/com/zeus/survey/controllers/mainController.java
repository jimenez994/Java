package com.zeus.survey.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {
	
	private int goldCoins = 0;
	private List<String> activities = new ArrayList<String>();
	private Random random = new Random();
	
	@RequestMapping("/")
	public String game(Model model) {
		model.addAttribute("coins", goldCoins);
		if(!activities.isEmpty()) {
			StringBuffer log = new StringBuffer();
			activities.forEach((message) -> log.insert(0, message));
			model.addAttribute("activities",log);
		}
		if(goldCoins >= 0) {
			return "index";
		}else {
			return "jail";
		}
	}
	
	@PostMapping("/play")
	public String play( @RequestParam("input") String input) {
		int coins;
		if(input.equals("farm")) {
			coins = random.nextInt((20 - 10) + 1) + 10;
		}else if ( input.equals("cave")) {
			coins = random.nextInt((10 - 5) + 1) + 5;			
		}else if ( input.equals("house")) {
			coins = random.nextInt((5 - 2) + 1) + 2;			
		}else if ( input.equals("casino")) {
			coins = random.nextInt((50 - -50) + 1) + -50;			
		} else {
			coins = 0;
		}
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, 'the' w 'of' MMMM ',' YYYY  ' ' hh':'mm':'ss " );
		final String date = simpleDateFormat.format(new Date()).toString();
		if(coins < 0) {
			activities.add("<p> - You lost <span class=\"lossCoins\">" + coins+ "</span> coins in " + input + " - " + date);
		}else {
			activities.add("<p> - You found <span class=\"gainCoins\">" + coins+ "</span> coins in " + input + " - " + date);			
		}
		goldCoins+=coins;
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset() {
		goldCoins =0;
		activities.clear();
		return "redirect:/";
	}

}
