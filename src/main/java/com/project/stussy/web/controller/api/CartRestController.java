package com.project.stussy.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
public class CartRestController {
	
	private final CartService cartService;
	
	@PostMapping("")
	public ResponseEntity<?> addCart(AddCartReqDto addCartReqDto) {
		log.info(">>>>> {}", addCartReqDto);
		int productCode = 0;
		
		try {
			productCode = cartService.addCart(addCartReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "add Failed", productCode));
		}
		
		return ResponseEntity.ok(new CMRespDto<>(1, "completing add", productCode));
	}
	
}
