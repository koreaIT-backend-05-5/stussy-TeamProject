package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	
	@GetMapping("/main")
	public String loadmain() {
		return "main/main";
	}
	
	@GetMapping("/account")
	public String loadAccountPage() {
		return "account/account-main";
	}
	
} 

