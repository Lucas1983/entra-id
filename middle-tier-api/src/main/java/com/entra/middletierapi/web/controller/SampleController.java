package com.entra.middletierapi.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

	@GetMapping("/middle")
	public String middleTierEndpoint() {
		log.info("Middle tier endpoint accessed");
		return "Middle Tier API is working!";
	}
}
