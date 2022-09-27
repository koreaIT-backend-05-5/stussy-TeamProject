package com.project.stussy.web.dto.product;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ProductMainRepDto {//스투시에서 shop버튼 클릭시 보여줄 페이지 dto(상품 all 페이지) 
	
	private int productCode; 
	private String productName;
	private String productPrice; 
	private int totalNoticeCount; 
	private List<Map<String, Object>> downloadFile; 

}
