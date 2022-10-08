package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping({"/", "/main"})
	public String loadmain() {
		return "main/main";
	}
	
	@GetMapping("/auth/signin")
	public String loadSignin() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String loadSignup() {
		return "auth/signup";
	}
	
	@GetMapping("/account")
	public String accountInfo() {
		return "cart/cart";
	}
	
	//=================내 정보 주소수정, 추가, 삭제================//
	
	@GetMapping("/account/addresses")
	public String addressesInfo() {
		return "account/account_addresses";
	}

}
