package com.project.stussy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDto { 

	private int cart_code; //상품관리 번호 
	private String cart_img; //상품 이미지 
	private String cart_name; //product_name , 상품명
	private int cart_price; //product_price, 상품금액
	private String cart_count; // 상품 수량 
	private String cart_totalprice; //상품 총금액 
	
	//회원아이디 
	private String user_eamil;
	
	//상품명 - 상품 dto에서 조인대상 
	private String product_name; 
	
	
	public CartDto(int cart_code, String cart_name, int cart_price, String cart_count, String user_email, String product_name) {
		this.cart_code = cart_code;
		this.cart_name = cart_name;
		this.cart_price = cart_price;
		this.cart_count = cart_count;
		this.user_eamil = user_email;
		this.product_name = product_name;
	}
	
	

}
