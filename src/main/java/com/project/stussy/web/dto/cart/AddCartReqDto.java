package com.project.stussy.web.dto.cart;

import com.project.stussy.domain.cart.Cart;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddCartReqDto {
	private int cartCode;
	private int userCode;
	private int productCode;
	private String bagProductSize;
	
	public Cart toCartEntity() {
		 return Cart.builder()
			.cart_code(getCartCode())
			.user_code(getUserCode())
			.product_code(getProductCode())
			.bag_product_size(getBagProductSize())
			.build();


	}
}

