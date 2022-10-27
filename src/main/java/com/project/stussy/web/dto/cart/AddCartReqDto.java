package com.project.stussy.web.dto.cart;

import java.time.LocalDateTime;

import com.project.stussy.domain.cart.Cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCartReqDto {
	private int cartCode;
	private int userCode;
	private int productCode;
	private String bagProductSize;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	
	public Cart toCartEntity() {
		 return Cart.builder()
			.cart_code(getCartCode())
			.user_code(getUserCode())
			.product_code(getProductCode())
			.bag_product_size(getBagProductSize())
			.create_date(getCreateDate())
			.update_date(getUpdateDate())
			.build();


	}
}

