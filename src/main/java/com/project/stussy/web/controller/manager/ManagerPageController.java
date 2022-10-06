package com.project.stussy.web.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerPageController {
	
	@GetMapping("/manager-user")
	public String loadUserList() {
		return "manager/manager-user";
	}
	
	@GetMapping("/product-update")
	public String loadUpdateList() {
		return "manager/product-update";
	}
}
