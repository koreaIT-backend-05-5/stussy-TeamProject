package com.project.stussy.web.dto.product;

import com.project.stussy.domain.cart.Cart;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductListDto { //service에서 보여주는 dto
	private int productCode;
	private String fileName;
	private String productCategory;
	private String productName;
	private String productPrice;
	private String productSize;
	private String productExplanation;
	
	
}
