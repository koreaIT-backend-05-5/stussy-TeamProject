package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping({"/", "/main"})
	public String loadmain() {
		return "main/main";
	}
	
	@GetMapping("/signin")
	public String loadSignin() {
		return "auth/signin";
	}
	
	@GetMapping("/signup")
	public String loadSignup() {
		return "auth/signup";
	}
	
	@GetMapping("/product-main")
	public String product() {
		return "products/product-main";
	}
	@GetMapping("/product-detail")
	public String productdetail() {
		return "products/product-detail";
	}
	
	@GetMapping("/account")
	public String accountInfo() {
		return "cart/cart";
	}
<<<<<<< HEAD
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
=======
	@GetMapping("/buy")
	public String buy() {
		return "buy/buyPage";
>>>>>>> 39ebc87ad3f22eca3f1c3bf5f760342d15aa4c22
	}
}
