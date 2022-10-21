package com.project.stussy.domain.cart;

import java.time.LocalDateTime;

import com.project.stussy.web.dto.cart.AddCartReqDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {
	private int cart_code;
	private int user_code;
	private int product_code; 
	private String bag_product_size;
	
	
	private LocalDateTime create_date;

	public AddCartReqDto toCartDto() {
		return AddCartReqDto.builder()
				.cartCode(cart_code)
				.userCode(user_code)
				.productCode(product_code)
				.bagProductSize(bag_product_size)
				.build();
	}
	
	
	
	
}
