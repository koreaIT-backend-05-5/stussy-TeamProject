package com.project.stussy.web.dto.product;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AddProductReqDto {
	private String productCategory;
	private String productName;
	private String productPrice;
	private String productExplanation;
	private List<MultipartFile> file;


}