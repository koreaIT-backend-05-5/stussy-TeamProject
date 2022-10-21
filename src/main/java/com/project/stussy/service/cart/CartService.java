package com.project.stussy.service.cart;

import com.project.stussy.web.dto.cart.AddCartReqDto;

public interface CartService {
	
	//<<장바구니 등록>>
	public int addCart(AddCartReqDto addCartReqDto) throws Exception;

}
