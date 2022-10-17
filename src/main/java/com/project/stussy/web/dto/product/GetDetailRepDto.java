package com.project.stussy.web.dto.product;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class GetDetailRepDto { 
	private int productCode;
	private String productName;
	private String productPrice;
	private String productSize;
	private String productInfo;
	
	private String fileName;


}
