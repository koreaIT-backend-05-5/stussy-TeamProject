package com.project.stussy.domain.product;

import java.time.LocalDateTime;

import com.project.stussy.domain.user.User;

public class Product { //product entity

	private int product_code;
	private String product_name;
	private String product_size;
	private String product_info;
	private int porduct_stock;
	private String product_price;
	private String product_category;
	private String product_status;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	private User user;
	
}
