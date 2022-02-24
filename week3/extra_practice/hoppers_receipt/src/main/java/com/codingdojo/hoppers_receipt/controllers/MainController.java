package com.codingdojo.hoppers_receipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(Model model) {
		
		String name = "Grace Hopper";
		String itemName = "Copper wire";
		double price = 5.25;
		String description = "Metal strips, also an illustration of nanoseconds.";
		String vendor = "Little Things Corner Store";
		
		model.addAttribute("customer_name", name);
		model.addAttribute("item_name", itemName);
		model.addAttribute("item_price", price);
		model.addAttribute("item_description", description);
		model.addAttribute("item_vendor", vendor);
		
		return "index.jsp";
	}
}