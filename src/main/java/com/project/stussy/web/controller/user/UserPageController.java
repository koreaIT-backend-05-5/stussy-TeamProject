package com.project.stussy.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class UserPageController {
	
	@GetMapping("/manager-user")
	public String loadUserList() {
		return "manager/manager-user";
	}
}
