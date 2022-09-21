package com.project.stussy.web.dto;

import java.time.LocalDateTime;

import com.project.stussy.domain.order.Order;

import lombok.Builder;

@Builder
public class OrderDto {
	
	private int user_code;
	private int order_code;
	private String order_name;
	private String order_number;
	private String order_price; 
	
	public Order toEntity() {
		return Order.builder()
				.user_code(user_code)
				.order_code(order_code)
				.order_name(order_name)
				.order_number(order_number)
				.order_price(order_price)
				.build();
	}
	
	 
}
