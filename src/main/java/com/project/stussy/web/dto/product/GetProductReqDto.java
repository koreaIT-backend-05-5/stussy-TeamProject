package com.project.stussy.web.dto.product;

import com.project.stussy.domain.product.Product;

import lombok.Data;

@Data
public class GetProductReqDto {
	private int productCode;
	private String productCategory;
	private String productName;
	private String productPrice;
	private String productExplanation;
	private int productCount;
	
	public Product toEntity() {
		return Product.builder()
				.product_code(productCode)
				.product_category(productCategory)
				.product_name(productName)
				.product_price(productPrice)
				.product_explanation(productExplanation)
				.product_count(productCode)
				.build();
	}
}
