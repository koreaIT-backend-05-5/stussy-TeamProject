package com.project.stussy.web.dto.product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductListResponseDto {
	private int productCode;
	private String productName;
	private String createDate;
	private int productCount;
	private int totalProductCount;
}