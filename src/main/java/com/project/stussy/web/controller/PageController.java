package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@GetMapping("/shop/{productType}")
	public String loadProductShop() {
		return "products/product-main"; 
	}
	@GetMapping("/detail/{productCode}")
	public String loadProductDetail() {
		return "products/product-detail";
	} 
	
	@GetMapping("/auth/signin")
	public String loadSignin() {
		return "auth/signin";
	}
	@GetMapping("/auth/signup")
	public String loadSignup() {
		return "auth/signup";
	}
	@GetMapping("/main")
	public String loadmain() {
		return "main/main";
	}

	@GetMapping("/cart")
	public String loadCart() {
		return "cart/cart";
	}
	
	@GetMapping("/account")
	public String loadAccountPage() {
		return "account/account-main";
	}
	
	//===========결제 관련 ===========//
	@GetMapping("/import")
	public String loadImport() {
		return "/import";
	}
	@GetMapping("/buy")
	public String loadBuy() {
		return "buy/buyPage";
	}
	@GetMapping("/checkouts")
	public String loadcheckouts() {
		return "checkouts/checkouts";
	}
	@GetMapping("/checkoutscard")
	public String loadcheckoutscard() {
		return "checkouts/checkouts_card";
	}
	@GetMapping("/contactinsert")
	public String loadcontactinsert() {
		return "contact/contact_insert";
	}
	
	//==========관리자 페이지 관련 =======//
	
	
} 

