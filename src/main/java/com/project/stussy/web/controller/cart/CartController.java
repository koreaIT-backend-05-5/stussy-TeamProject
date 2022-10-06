package com.project.stussy.web.controller.cart;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.stussy.service.cart.CartService;
import com.project.stussy.web.dto.CMRespDto;
import com.project.stussy.web.dto.cart.AddCartReqDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {
	
	private final CartService cartService;
	
	@GetMapping("/list")
	public ModelAndView read(Principal principal) throws Exception {
		List<AddCartReqDto> list = cartService.read(principal.getName()); 
		return new ModelAndView("/list").addObject("list", list);
	}
	
	@PostMapping("/add")
	public String add(int productCode, int cartCount, Principal principal) throws Exception {
		Boolean result = cartService.add(productCode, cartCount, principal.getName()); 
		if(result == false) {
			return "redirect:/api/v1/product?productCode=" + productCode; 
		}
		return "redirect:/list"; 
	}
	
}
