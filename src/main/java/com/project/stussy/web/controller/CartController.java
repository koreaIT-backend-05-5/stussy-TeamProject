package com.project.stussy.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.stussy.service.cart.CartService;
import com.project.stussy.web.dto.CartDeleteDto;
import com.project.stussy.web.dto.CartDto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
	
	private final CartService cartService;
	
	//장바구니 보기 
	@GetMapping("/list")
	public ModelAndView read (Principal principal) throws Exception {
		List<CartDto> list = cartService.read(principal.getName());
		return new ModelAndView("/list").addObject("list", list);
	}
	
	//장바구니 담기 - 이미 담긴 상품의 경우 갯수 증가 
	@PostMapping("/add")
	public String add(int cart_code, int cart_count, Principal principal) throws Exception {
		Boolean result = cartService.add(cart_code, cart_count, principal.getName()); 
		if(result == false) {
			return "redirect:/=" + cart_code;
		}
		return "redirect:/cart/list";
	}
	
	//장바구니에서 물품 갯수 감소
	@PutMapping("/decrease/{cart_code}")
	public ResponseEntity<Integer> decrease(@PathVariable int cart_code, Principal principal) throws Exception {
		int cart_count = cartService.decrease(cart_code, principal.getName());
		if(cart_count <= 0) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(cart_count);
		}
		return ResponseEntity.ok(cart_count); 
	}
	
	//장바구니에서 삭제 
	@PostMapping("/delete")
	public String delete(CartDeleteDto deleteDto, Principal principal) throws Exception {
		cartService.delete(deleteDto, principal.getName());
		return "redirect:/cart/list";
	}
	
}
