package com.zeus.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String index() {
        return "forward:/index.html";
    }
	 @RequestMapping("/me_view")
     public String me() {
             return "me.html";
     }
	 @RequestMapping("/projects_view")
     public String project() {
             return "projects.html";
     }
	

}
