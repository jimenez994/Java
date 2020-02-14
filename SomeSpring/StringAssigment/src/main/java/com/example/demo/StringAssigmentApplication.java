package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringAssigmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringAssigmentApplication.class, args);
	}
	
	@RequestMapping("/")
	public String home() {
		return "hello you are currently at home";
	}
	
	@RequestMapping("/random")
	public String ramdom() {
		return " hey this is actual something ramdom";
	}

}
