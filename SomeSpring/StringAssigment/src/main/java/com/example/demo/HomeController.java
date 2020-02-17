package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping("")
	public String home(final Model model) {
		model.addAttribute("name", "Jonathan");
		return "index";
	}

	@RequestMapping(value = "/cool", method = RequestMethod.GET)
	public String cool() {
		return "index";
	}

	@RequestMapping("/search")
	public String cool(@RequestParam(value = "something", required = false) final String search) {
		System.out.print(search);
		return search;
	}

	@RequestMapping("/java")
	public String javaM(final Model model) {
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, 'the' w 'of' MMMM ',' YYYY ");
		final String date = simpleDateFormat.format(new Date()).toString();
		model.addAttribute("date", date);
		model.addAttribute("name", "Jonathan");

		System.out.println("got here");
		return "html/java";
	}

	@RequestMapping("/python")
	public String pythn(final Model model) {
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("kk ':' m aa");
		final String time = simpleDateFormat.format(new Date()).toString();
		model.addAttribute("time", time);
		return "html/python";
	}

	@RequestMapping("/react")
	public String react(final HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		int count = (int) session.getAttribute("count");
		count++;
		session.setAttribute("count", count);
		model.addAttribute("counter", count);
		return "html/react";
	}

}
