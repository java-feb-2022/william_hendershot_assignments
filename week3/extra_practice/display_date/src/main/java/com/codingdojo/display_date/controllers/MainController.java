package com.codingdojo.display_date.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String display_index_page() {		
		
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String display_date_page(Model model) {
		Date currentDate = new Date();
		SimpleDateFormat date_format = new SimpleDateFormat("EEEE', the 'dd' of 'MMMM', 'yyyy");
		model.addAttribute("date", date_format.format(currentDate).toString());
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String display_time_page(Model model) {
		Date currentDate = new Date();
		SimpleDateFormat time_format = new SimpleDateFormat("hh:mm a");
		model.addAttribute("time", time_format.format(currentDate).toString());
		
		return "time.jsp";
	}

}