package com.project.stussy.web.dto.product;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class GetDetailRepDto { 
	
	private int productCode; 
	private String productName;
	private String productPrice; 
	private String productSize; 
	private String productExplanation; 
	private List<Map<String, Object>> downloadFiles; 

}
