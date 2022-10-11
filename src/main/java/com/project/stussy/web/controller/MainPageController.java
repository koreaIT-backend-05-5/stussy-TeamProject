package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
	
	//일반 메인 페이지
	@GetMapping("/main")
	public String loadmain() {
		return "main/main";
	}
	
	//관리자 메인 페이지
	@GetMapping("/manager/main")
	public String loadMain() {
		return "manager/manager-main";
	}

} 

