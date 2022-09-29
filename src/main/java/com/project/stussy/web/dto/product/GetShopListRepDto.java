package com.project.stussy.web.dto.product;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetShopListRepDto {
	
	private int productCode; 
	private String productName;
	private String productPrice;
	private int totalProductCount; 
	private List<Map<String, Object>> downloadFile; //상품이미지자리 

}
