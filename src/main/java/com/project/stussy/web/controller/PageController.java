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
	@GetMapping("/import")
	public String imports() {
		return "import";
	}
	@GetMapping("/products/main")
	public String produtsmain() {
		return "products/product-main";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact/contact";
	}
}
