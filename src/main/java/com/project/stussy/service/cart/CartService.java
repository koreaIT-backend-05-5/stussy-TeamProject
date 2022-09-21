package com.project.stussy.service.cart;

import java.util.List;

import com.project.stussy.web.dto.CartDeleteDto;
import com.project.stussy.web.dto.CartDto;

public interface CartService {
	//장바구니 읽기
	public List<CartDto> read(String user_email) throws Exception; 

	//장바구니 상품 추가
	public boolean add(int cart_code, int cart_count, String user_email) throws Exception; 
	
	//장바구니 상품 감소 
	public int decrease(int cart_code, String user_eamil) throws Exception; 
	
	//장바구니에서 상품 삭제
	public void delete(CartDeleteDto cartDeleteDto, String user_eamil) throws Exception;
}
	