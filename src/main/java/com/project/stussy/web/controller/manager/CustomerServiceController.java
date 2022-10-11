package com.project.stussy.web.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class CustomerServiceController {
	
	//관리자 고객관리 페이지
	@GetMapping("/customer")
	public String loadSignin() {
		return "manager/manager-user";
	}
}
