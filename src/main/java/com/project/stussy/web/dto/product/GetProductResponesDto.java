package com.project.stussy.web.dto.product;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.project.stussy.domain.product.Product;

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
	private MultipartFile file;
	private String fileName;
//	private int productCount;
	
	public Product toEntity() {
		return Product.builder()
		.product_code(productCode)
		.product_category(productCategory)
		.product_name(productName)
		.product_price(productPrice)
		.product_size(productSize)
		.product_explanation(productExplanation)
		.file_name(UUID.randomUUID().toString().replaceAll("-", "") + "_" + file.getOriginalFilename())
		.build();
		
	}
	
	

	
}
