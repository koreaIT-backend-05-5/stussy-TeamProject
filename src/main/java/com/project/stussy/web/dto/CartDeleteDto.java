package com.project.stussy.web.dto;

import java.util.List;

import lombok.Data;

@Data
public class CartDeleteDto {
	private List<Integer> cart_codes;
	
}
