package com.project.stussy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class PageController {
	
	@GetMapping("/shop")
	public String loadProductShop() {
		return "products/product-main"; 
	}
	
<<<<<<< HEAD
	@GetMapping("/detail/{productCode}")
	public String loadProductDetail() {
		return "products/product-detail"; 
=======
	@GetMapping("/signin")
	public String loadSignin() {
		return "auth/signin";
>>>>>>> origin/kyung
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

=======
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
>>>>>>> origin/kyung
}

