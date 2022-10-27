package com.project.stussy.web.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadUserCartRespDto {
	private int cartCode;
	private String productName;
	private String bagProductSize;
	private int bagAmount;
	private String productPrice;
	private String fileName;
	
	
}

