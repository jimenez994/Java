package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dojo")
public class ControllerDojo {
	
//	@RequestMapping("/{dojo}")
//	public String dojo(@PathVariable String dojo) {
//		return dojo;
//	}
	
	@RequestMapping("/word/{word}")
	public String someWord(@PathVariable String word) {
		return word;
	}
	
	@RequestMapping("/name/{name}")
	public String someName(@PathVariable String name) {
		System.out.print(name + "******");
		return "hi " + name;
	}
	@RequestMapping("/name")
	public String noName() {
			return "hello human";
	}

}
