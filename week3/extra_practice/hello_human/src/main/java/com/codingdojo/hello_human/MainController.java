package com.codingdojo.hello_human;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String firstName,
			@RequestParam(value="last_name", required=false) String lastName,
			@RequestParam(value="times", required=false) Integer times
			) {
		
		System.out.printf("FirstName: %s, lastName: %s, times: %d%n", firstName, lastName, times);
		String result = "";
		
		if (firstName == null) {firstName = "Human";}
		if (lastName == null) {lastName = "";}
		if (times == null) {times = 1;}
		
		for (int i = 0; i < times; i++) {
			result += String.format("Hello %s %s<br>", firstName, lastName);
		}
		return result;
	}
}
