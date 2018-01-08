package com.zeus.firstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}
	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}
	@RequestMapping("/random")
	public String bla() {
		return "Is this working?";
	}
}
