package com.project.stussy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiController {

	@GetMapping("/auth/signin")
	public String loadmain() {
		return "/auth/signin";
	}
}
