package com.project.stussy.domain.cart;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.project.stussy.domain.product.Product;
import com.project.stussy.domain.product.ProductFile;
import com.project.stussy.domain.user.User;
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
	private int cart_count; 
	private String cart_total_price; 
	
	private String product_name;
	private String product_price; 
	
	private int file_code;
	private String file_name;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date; 
	
	private int total_cart_count; 
	
	public AddCartReqDto toCartDto() {
		return AddCartReqDto.builder()
				.cartCode(cart_code)
				.userCode(user_code)
				.productCode(product_code)
				.cartCount(cart_count)
				.cartTotalPrice(cart_total_price)
				.productName(product_name)
				.productPrice(product_price)
				.fileName(file_name)
				.totalCartCount(total_cart_count)
				.build();
	}
		
}
