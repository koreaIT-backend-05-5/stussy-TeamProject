package com.project.stussy.domain.cart;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartRepository {
	//저장
	public int saveCart(Cart cart) throws Exception;
	
	//사용자 장바구니 
	public List<Cart> getCartList(int userCode) throws Exception; 
	
	//장바구니 동일 상품 유무
	
	public Cart getCart(Map<String, Object> map) throws Exception;
	
	//장바구니 수량 수정
	public int updateAmount(int cart_code, int amount) throws Exception; 

	
	//장바구니 상품 삭제
	public int deleteCart(int cart_code) throws Exception;
}
