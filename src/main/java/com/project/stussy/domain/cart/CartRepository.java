package com.project.stussy.domain.cart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartRepository {
	
	//장바구니에 저장
	public void save(CartItem cartItem);
	
	//해당 사용자의 장바구니 찾기
	List<CartItem> findByUsername(String user_email);
	
	//장바구니 내 상품 찾기
	CartItem findByUsernameAndPno(String user_email, int cart_code);
	
	//장바구니 상품 갯수 증가
	public void increase(CartItem cartItem);
	
	//장바구니 상품 갯수 감소
	public void decrease(CartItem cartItem); 
	
	//장바구니에서 삭제
	public void delete(List<Integer> cart_codes , String user_email);
	
}
