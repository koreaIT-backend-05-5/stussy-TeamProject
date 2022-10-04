package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stussy")
public class PageController {
	
	//동영이형
	@GetMapping("/shop")
	public String loadProductShop() {
		return "products/product-main"; 
	}
	//동영이형
	@GetMapping("/detail/{productCode}")
	public String loadProductDetail() {
		return "products/product-detail";
	} 
	
	//원영이형
	@GetMapping("/signin")
	public String loadSignin() {
		return "auth/signin";
	}
	//원영이형
	@GetMapping("/signup")
	public String loadSignup() {
		return "auth/signup";
	}
	//내꺼
	@GetMapping("/product-main")
	public String product() {
		return "products/product-main";
	}
	//내꺼
	@GetMapping("/product-detail")
	public String productdetail() {
		return "products/product-detail";
	}


}

