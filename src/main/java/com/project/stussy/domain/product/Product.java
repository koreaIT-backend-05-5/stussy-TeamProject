package com.project.stussy.domain.product;


import java.time.LocalDateTime;

import com.project.stussy.web.dto.product.GetProductListDto;
import com.project.stussy.web.dto.product.GetProductResponesDto;
import com.project.stussy.web.dto.product.GetShopListRepDto;
import com.project.stussy.web.dto.product.GetDetailRepDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	private int product_code; //등록시 상품번호
	private String product_category; // 카테고리
	private String product_name; //상품명
	private String product_price; //상품금액
	private String product_explanation; //상품설명
	private String product_size; //상품사이즈
	private int product_count; //페이지.
	
	
	private int file_code;
	private String file_name;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	private int total_product_count; 

	
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
	
	//shop
	//상품상세페이지 dto
	public GetDetailRepDto toDetailDto() {
		return GetDetailRepDto.builder()
				.productCode(product_code)
				.productName(product_name)
				.productPrice(product_price)
				.productSize(product_size)
				.productExplanation(product_explanation)
				.fileName(file_name)
				.build();
	}
	
	public GetShopListRepDto toShopListDto() {
		return GetShopListRepDto.builder()
				.productCode(product_code)
				.productName(product_name)
				.productPrice(product_price)
				.totalProductCount(total_product_count)
				.fileName(file_name)
				.build(); 
	}
	
	
	
}
