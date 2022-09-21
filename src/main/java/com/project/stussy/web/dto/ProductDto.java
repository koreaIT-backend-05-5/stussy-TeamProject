package com.project.stussy.web.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {//상품등록시 
	
	private String product_name;
	private int product_price;
	private String product_size;

}
