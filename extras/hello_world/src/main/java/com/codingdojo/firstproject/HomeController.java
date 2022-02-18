package com.codingdojo.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String hello() {
		return "Hello World!!";
	}

	@RequestMapping("/dojo")
	public String dojo() {
		return "And now I have to remember some more HTML stuff again!";
	}
}
