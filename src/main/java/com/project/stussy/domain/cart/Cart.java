package com.project.stussy.domain.cart;

import java.time.LocalDateTime;

import com.project.stussy.web.dto.cart.AddCartReqDto;
import com.project.stussy.web.dto.cart.ReadUserCartRespDto;

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
	private String product_name;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	private int bag_amount;
	private String product_price;
	private String file_name;
	

	public AddCartReqDto toCartDto() {
		return AddCartReqDto.builder()
				.cartCode(cart_code)
				.userCode(user_code)
				.productCode(product_code)
				.bagProductSize(bag_product_size)
				.createDate(create_date)
				.updateDate(update_date)
				.build();
	}
	
	public ReadUserCartRespDto toReadUserCartRespDto() {
		return ReadUserCartRespDto.builder()
				.cartCode(cart_code)
				.bagProductSize(bag_product_size)
				.productPrice(product_price)
				.productName(product_name)
				.bagAmount(bag_amount)
				.fileName(file_name)
				.build();
	}
	
	
	
	
}
