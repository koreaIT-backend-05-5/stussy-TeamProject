package com.project.stussy.web.controller.cart;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stussy.service.cart.CartService;
import com.project.stussy.web.dto.CMRespDto;
import com.project.stussy.web.dto.cart.AddCartReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Slf4j
public class CartListController {
	
	private final CartService cartService; 
	
	@GetMapping("/{page}")
	public ResponseEntity<?> getCartList(@PathVariable int page) {
		List<AddCartReqDto> addCartReqDto = null; 
		
		try {
			addCartReqDto = cartService.getCartList(page);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", addCartReqDto));
		} 
		return ResponseEntity.ok(new CMRespDto<>(1, "lookup successful", addCartReqDto));
	}
	
	@GetMapping("/remove/{productCode}")
	public ResponseEntity<?> removeCart(@PathVariable int productCode) {
		boolean status = false; 
		try {
			status = cartService.removeCart(productCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failed", status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", status));
	}

}
