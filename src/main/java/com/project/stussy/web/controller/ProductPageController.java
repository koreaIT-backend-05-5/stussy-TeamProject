package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ProductPageController {
	
	@GetMapping("/product-update")
	public String loadProduct() {
		return "manager/product-update";
	}

	@GetMapping("/product-list")
	public String loadProductList() {
		return "manager/product-list";
	}
	
	@GetMapping("/product-modify/{productCode}")
	public String loadProductModify() {
		return "manager/product-modify";
	}
	
<<<<<<< HEAD
	@GetMapping("/product-list/{productCode}")
	public String loadProductDelete() {
		return "manager/product-list";
	}
	
	
=======
>>>>>>> origin/eastzi
}
