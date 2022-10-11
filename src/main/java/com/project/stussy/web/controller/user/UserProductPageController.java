package com.project.stussy.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class UserProductPageController {
	
	//상품 목록 카테고리 페이지
	@GetMapping("/shop/{productType}")
	public String loadProductShop() {
		return "products/product-main"; 
	}
	
	//상품 상세 페이지
	@GetMapping("/detail/{productCode}")
	public String loadProductDetail() {
		return "products/product-detail";
	} 
	
}
