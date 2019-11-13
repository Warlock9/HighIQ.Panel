package com.augustconsulting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class MainController {

	
	

	@RequestMapping("/")
	public String mainLandingPageonLogout(Model model) {
		
		return new String("dashboard");
	}
	
	

}	