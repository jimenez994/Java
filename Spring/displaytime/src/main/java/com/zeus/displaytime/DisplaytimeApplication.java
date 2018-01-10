package com.zeus.displaytime;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@RequestMapping("/")

public class DisplaytimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplaytimeApplication.class, args);
		
	}
	@RequestMapping("")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		}else {
			session.setAttribute("count",(Integer) session.getAttribute("count")+1);
		}
		
		return "index.jsp";
	}
	@RequestMapping("/date_view")
	public String date(Model model) {
		SimpleDateFormat date= new SimpleDateFormat("EEEE, 'the' d 'of' MMM , yyyy");
		Date now = new Date();
		model.addAttribute("date",date.format(now));
		return "date.jsp";
	}
	@RequestMapping("/time_view")
	public String time(Model model) {
		SimpleDateFormat time = new SimpleDateFormat("hh:mm a");
		Date date = new Date();
		model.addAttribute("time",time.format(date));
		return "time.jsp";
	}
	
	@RequestMapping("/counter_view")
	public String counter() {
		
		return "counter.jsp";
	}
	
}
