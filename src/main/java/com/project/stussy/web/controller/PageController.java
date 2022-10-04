package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class PageController {
	
	@GetMapping("/shop")
	public String loadProductShop() {
		return "products/product-main"; 
	}
	
	@GetMapping("/detail/{productCode}")
	public String loadProductDetail() {
		return "products/product-detail"; 
	}

	
	@GetMapping("/auth/signup")
	public String loadSignup() {
		return "auth/signup";
	}
	
	@GetMapping("/account")
	public String accountInfo() {
		return "cart/cart";
	}

}

