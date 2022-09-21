package com.project.stussy.web.dto;

import java.util.List;

import lombok.Data;

@Data
public class CartOrderDto { //주문할 상품 데이터 전달 dto
	
	@Data
	public static class Param{
		private int cart_code; 
		private String product_size; 
	}
	
	private List<Param> list; 
	

}
