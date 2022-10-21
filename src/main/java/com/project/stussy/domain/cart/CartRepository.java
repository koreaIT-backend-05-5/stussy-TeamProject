package com.project.stussy.domain.cart;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartRepository {
	//저장
	public void saveCart(Cart cart) throws Exception;
	
	//사용자 장바구니 찾기
	public List<Cart> getCartList(Map<String, String> map) throws Exception; 
	
	//장바구니 상품 삭제
	public void delete(List<Integer> productCodes, String userEmail) throws Exception;
}
