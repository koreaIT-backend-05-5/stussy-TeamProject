package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	//동영이형
	@GetMapping("/shop/{productType}")
	public String loadProductShop() {
		return "products/product-main"; 
	}
	//동영이형
	@GetMapping("/detail/{productCode}")
	public String loadProductDetail() {
		return "products/product-detail";
	} 
	
	//원영이형
	@GetMapping("/auth/signin")
	public String loadSignin() {
		return "auth/signin";
	}
	//원영이형
	@GetMapping("/auth/signup")
	public String loadSignup() {
		return "auth/signup";
	}
	@GetMapping("/main")
	public String loadmain() {
		return "main/main";
	}

	@GetMapping("/account")
	public String loadAccountPage() {
		return "account/account-main";
	}
}

