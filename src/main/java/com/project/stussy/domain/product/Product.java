package com.project.stussy.domain.product;


import java.time.LocalDateTime;

import com.project.stussy.web.dto.product.GetProductListDto;
import com.project.stussy.web.dto.product.GetProductResponesDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	private int product_code;
	private String product_category;
	private String product_name;
	private String product_price;
	private String product_explanation;
	private String product_size;
	private int product_count;
	
	
	private int file_code;
	private String file_name;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	
	
	//<<<DTO -> Entity>>>
	public GetProductListDto toListDto() {
		return GetProductListDto.builder()
				.productCode(product_code)
				.fileName(file_name)
				.productName(product_name)
				.productCategory(product_category)
				.productPrice(product_price)
				.productSize(product_size)
				.productExplanation(product_explanation)
				.build();
	}
	
	public GetProductResponesDto toReqDto() {
		return GetProductResponesDto.builder()
				.productCode(product_code)
				.productCategory(product_category)
				.productName(product_name)
				.productPrice(product_price)
				.productSize(product_size)
				.productExplanation(product_explanation)
				.fileName(file_name)
				.build();
	}	
	
	
	
}
