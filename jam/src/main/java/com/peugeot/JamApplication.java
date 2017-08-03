package com.peugeot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class JamApplication {

	public static void main(String[] args) {
		SpringApplication.run(JamApplication.class, args);
	}

	@RequestMapping("/")
	public String login(){
		return "login";
	}
}


