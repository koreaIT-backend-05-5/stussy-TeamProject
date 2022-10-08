package com.project.stussy.web.dto.cart;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddCartReqDto {
	private int cartCode; 
	private int userCode; 
	private int productCode;
	private int cartCount; 
	private String cartTotalPrice; 
	
	private String productName;
	private String productPrice;
	
	private String fileName;
	private int totalCartCount; 
}
