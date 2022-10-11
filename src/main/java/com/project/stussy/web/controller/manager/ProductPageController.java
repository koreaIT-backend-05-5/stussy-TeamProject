package com.project.stussy.web.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ProductPageController {
	
	
	//관리자 상품 등록 페이지
	@GetMapping("/product-update")
	public String loadProduct() {
		return "manager/product-update";
	}

	//관리자 상품 리스트 페이지
	@GetMapping("/product-list")
	public String loadProductList() {
		return "manager/product-list";
	}

	//관리자 상품 수정 페이지
	@GetMapping("/product-modify/{productCode}")
	public String loadProductModify() {
		return "manager/product-modify";
	}
	
	//관리자 상품 삭제 페이지
	@GetMapping("/product-list/{productCode}")
	public String loadProductDelete() {
		return "manager/product-list";
	}
	
	
}
