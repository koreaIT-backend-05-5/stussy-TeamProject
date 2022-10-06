package com.project.stussy.web.dto.cart;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddCartReqDto {
	private int productCode;
	private String userEmail;
	private int cartCode;
	private int cartCount; 
	private String cartTotalPrice;
	private String productName;
	private String productPrice;
	private int fileCode;
	private String fileName;
	
	private List<Integer> productCodes;
}
