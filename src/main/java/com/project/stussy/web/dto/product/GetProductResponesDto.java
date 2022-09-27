package com.project.stussy.web.dto.product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductResponesDto {
	private int productCode;
	private String productCategory;
	private String productName;
	private String productPrice;
	private String productSize;
	private String productExplanation;
	private String fileName;
	private int productCount;
	
	

	
}
