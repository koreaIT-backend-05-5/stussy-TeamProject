package com.project.stussy.service.cart;

import java.util.List;

import com.project.stussy.web.dto.cart.AddCartReqDto;

public interface CartService {
	
	//장바구니 추가 
	public int addCart(AddCartReqDto addCartReqDto) throws Exception; 
	
	//장바구니 리스트 
	public List<AddCartReqDto> getCartList(int page) throws Exception; 
	
	//장바구니 삭제 
	public boolean removeCart(int productCode) throws Exception; 
}
