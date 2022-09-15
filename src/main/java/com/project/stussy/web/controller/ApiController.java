package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/main")
	public String loadmain() {
		return "main/main";
	}
	
	@GetMapping("/account")
	public String accountInfo() {
		return "cart/cart";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "auth/signup";
	}
	
	@PostMapping("/signup")
	public String signupf() {
		return "auth/signup";
	}
}
