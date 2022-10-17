package com.project.stussy.web.dto.product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetShopListRepDto {
	
	private int productCode; 
	private String productName;
	private String productPrice;
	private int totalProductCount; 
	private String fileName; //상품이미지자리 

}
