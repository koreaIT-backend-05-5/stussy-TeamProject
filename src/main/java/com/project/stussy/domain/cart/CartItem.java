package com.project.stussy.domain.cart;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItem { //cart entity
	private int cart_code; 
	private String cart_img;
	private String cart_name;
	private int cart_number;
	private String cart_price;
	private String cart_totalprice;
	
	private LocalDateTime create_date;
	
	private int product_imgcode; 
	
	
//	public GetCartItemListResponseDto toListDto() {
//		return GetCartItemListResponseDto.builder()
//										.cartImg(cart_img)
//										.cartName(cart_name)
//										.cartNumber(cart_number)
//										.cartPrice(cart_price)
//										.cartTotalprice(cart_totalprice)
//										.build();
//	}

}
