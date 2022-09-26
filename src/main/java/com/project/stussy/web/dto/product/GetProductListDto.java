package com.project.stussy.web.dto.product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductListDto {
	private int productCode;
	private String fileName;
	private String productCategory;
	private String productName;
	private String productPrice;
	private String productSize;
	private String productExplanation;
	private int totalProductCount;
	
}
