package com.project.stussy.web.dto.product;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.project.stussy.domain.product.Product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductResponesDto { //원영이형
	private int productCode;
	private String productCategory;
	private String productName;
	private String productPrice;
	private String productSize;
	private String productExplanation;
	private MultipartFile file;
	private String fileName;
	
	public Product toEntity() {
		return Product.builder()
		.product_code(productCode)
		.product_category(productCategory)
		.product_name(productName)
		.product_price(productPrice)
		.product_size(productSize)
		.product_explanation(productExplanation)
		.file_name(createFileName())
		.build();
		
	}
	
	// input 태그의 file은 파일을 선택하지 않아도 file object가 들어가있는데
	// 이대로 file_name으로 entity 변환을 해주면 "" entity로 변환되고 이상태로 db 업데이트 퀴리가 실행되면
	// file_name이 공백으로 변해서 기존 이미지가 날아감
	// .getOriginalFilename() 은 선택했을때 file 이름이 나오니까 파일을 선택하지 않았기때문에
	// 공백으로 나옵니다. 여기서 .isBlank() 는 공백이면 true 아니면 false
	// 처음에 !로 부정을 해줘서 공백이 아닐때 false 니까 => true 바뀌어서 if문 실행
	private String createFileName() {
		String fileName = null;
		if(!file.getOriginalFilename().isBlank()) {
			fileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + file.getOriginalFilename();
		}
		return fileName;
	}

	
}
