package com.springecom.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// this for testing purpose
//add another comment
@RestController
public class HelloController {
	@GetMapping("/home")
	public String greet() {
		return "Welcome to new project using rest api and react Aditya !"
				+ " Let them fucking chill on weekends but you keep grinding";
	}
}
