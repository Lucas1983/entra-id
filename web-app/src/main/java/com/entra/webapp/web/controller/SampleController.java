package com.entra.webapp.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

	@GetMapping("/")
	public String login() {
		log.info("Login endpoint accessed");
		return "Login Successful!";
	}

	@GetMapping("/hello")
	public String helloWorld() {
		log.info("Hello endpoint accessed");
		return "Hello World!";
	}
}
