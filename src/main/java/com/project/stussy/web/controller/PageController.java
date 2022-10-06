package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stussy")
public class PageController {
	
	@GetMapping("/shop")
	public String loadProductShop() {
		return "products/product-main"; 
	}
	
	@GetMapping("/detail/{productCode}")
	public String loadProductDetail() {
		return "products/product-detail"; 
	}
	
	@GetMapping("/cart")
	public String loadCart() {
		return "cart/cart";
	}
	
	
} 
