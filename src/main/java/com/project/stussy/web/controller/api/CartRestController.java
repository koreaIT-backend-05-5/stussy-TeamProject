package com.project.stussy.web.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stussy.exception.ProductValidationApiException;
import com.project.stussy.service.cart.CartService;
import com.project.stussy.web.dto.CMRespDto;
import com.project.stussy.web.dto.cart.AddCartReqDto;
import com.project.stussy.web.dto.cart.ReadUserCartRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartRestController {
	
	private final CartService cartService;
	
	//장바구니 상품 등록
	@PostMapping("")
	public ResponseEntity<?> addCart(AddCartReqDto addCartReqDto) {

		System.out.println(addCartReqDto);
		boolean status = false;
		try {
			status = cartService.addCart(addCartReqDto);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "add Failed", status));
		}
		
		if(!status) {
			throw new ProductValidationApiException("Already hav cart");
		}
		return ResponseEntity.ok(new CMRespDto<>(1, "completing add", status));
	}
	
	//장바구니 상품 리스트
	@GetMapping("/{userCode}")
	public ResponseEntity<?> loadUserCart(@PathVariable int userCode) {

		List<ReadUserCartRespDto> userCartList = null;
		
		try {
			userCartList = cartService.getCartList(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "add Failed", userCartList));
		}
		
		return ResponseEntity.ok(new CMRespDto<>(1, "completing add", userCartList));
	}
	
	//장바구니 상품 수량 수정
	@PutMapping("/{cartCode}")
	public ResponseEntity<?> updateBagAmount(@PathVariable int cartCode, @RequestBody Map<String, Integer> map) {
		int status = 0;
		
		System.out.println(map);
		try {
			status = cartService.updateAmount(cartCode, map.get("amount"));
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "add Failed", status));
		}
		
		
		return ResponseEntity.ok(new CMRespDto<>(1, "completing add", status));
	}
	
	//장바구니 상품 삭제
	@DeleteMapping("/{cartCode}")
	public ResponseEntity<?> deleteCart(@PathVariable int cartCode){
		boolean status = false;
		try {
			status = cartService.deleteCart(cartCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failed", status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", status));
	}
		
}

	
