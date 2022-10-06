package com.project.stussy.domain.cart;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartRepository {
	//저장
	public void save(Cart cart) throws Exception;
	
	//사용자 장바구니 찾기
	public List<Cart> findByUserName(String userEmail, int productCode) throws Exception; 
	
	//장바구니 내 상품 찾기
	public Cart findByCartList(String userEmail, int productCode) throws Exception; 
	
	//장바구니 상품 수량 증가
	public void increase(Cart cart) throws Exception; 
	
	//장바구니 상품 개수 감소
	public void decrease(Cart cart) throws Exception; 
	
	//장바구니 상품 삭제
	public void delete(List<Integer> productCodes, String userEmail) throws Exception;
}
