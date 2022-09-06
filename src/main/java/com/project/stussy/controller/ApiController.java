package com.project.stussy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/main")
	public String loadmain() {
		return "main/main";
	}
}
