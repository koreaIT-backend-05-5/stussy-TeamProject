package com.project.stussy.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class UProductPageController {
	@GetMapping("/shop/{productType}")
	public String loadProductShop() {
		return "products/product-main"; 
	}
	@GetMapping("/detail/{productCode}")
	public String loadProductDetail() {
		return "products/product-detail";
	} 
	
}
