package com.project.stussy.domain.product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	private int product_code;
	private String product_category;
	private String product_name;
	private String product_price;
	private String product_explanation;
	private int product_count;
	private String create_date;
	private String update_date;
	
}
