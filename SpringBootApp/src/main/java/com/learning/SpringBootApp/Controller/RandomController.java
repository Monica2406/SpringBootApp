package com.learning.SpringBootApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class RandomController {
	@GetMapping("/msg")
	public String getMessage() {
		return "Hey SpringBoot";
	}
	

}
//http://localhost:8080/msg
