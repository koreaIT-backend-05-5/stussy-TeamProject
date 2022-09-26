package com.project.stussy.web.dto.product;

import java.util.List;

import lombok.Data;

@Data
public class AddProductReqDto { //상품등록 dto 
	private int productCode;
	private String productCategory;
	private String productName;
	private String productPrice;
	private String productExplanation;
	private String productSize;
//	private List<MultipartFile> file;
}
