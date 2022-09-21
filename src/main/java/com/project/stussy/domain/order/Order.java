package com.project.stussy.domain.order;

import java.time.LocalDateTime;

import com.project.stussy.web.dto.OrderDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

	private int user_code;
	private int order_code;
	private String order_name;
	private String order_number;
	private String order_price; 
	private LocalDateTime create_date;
	private LocalDateTime update_date; 
	
	public OrderDto toOrderDto() {
		return OrderDto.builder()
				.user_code(user_code)
				.order_code(order_code)
				.order_name(order_name)
				.order_number(order_number)
				.order_price(order_price)
				.build();
	}
}
