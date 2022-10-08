package com.project.stussy.domain.cart;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.stussy.web.dto.cart.AddCartReqDto;

@Mapper
public interface CartRepository {
	
	//장바구니 리스트
	public List<Cart> getCartList(Map<String, Object> map) throws Exception; 
	
	//장바구니 추가 
	public int addCartProduct(AddCartReqDto addCartReqDto) throws Exception; 
	
	public Cart checkCart(AddCartReqDto addCartReqDto) throws Exception; 
	
	//장바구니 내역 삭제
	public int remove(int productCode) throws Exception; 
}
