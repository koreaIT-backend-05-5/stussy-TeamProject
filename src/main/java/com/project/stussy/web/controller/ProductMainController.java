package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductMainController {
	
	@GetMapping("/main")
	public String productMainPage() {
		return "product/product-main";
	}
}
