package com.project.stussy.service.cart;

import java.util.List;

import com.project.stussy.web.dto.cart.AddCartReqDto;
import com.project.stussy.web.dto.cart.ReadUserCartRespDto;

public interface CartService {
	
	//장바구니 등록
	public boolean addCart(AddCartReqDto addCartReqDto) throws Exception;
	
	//장바구니 리스트
	public List<ReadUserCartRespDto> getCartList(int userCode) throws Exception;
	
	//장바구니 수량 수정
	public int updateAmount(int cartCode, int amount) throws Exception;
	
	//장바구니 상품 삭제
	public boolean deleteCart(int cart_code) throws Exception;

}
