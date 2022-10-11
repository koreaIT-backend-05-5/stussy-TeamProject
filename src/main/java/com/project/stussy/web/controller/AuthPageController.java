package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthPageController {

	@GetMapping("/signin")
	public String loadSignin() {
		return "auth/signin";
	}
	@GetMapping("/signup")
	public String loadSignup() {
		return "auth/signup";
	}
}
