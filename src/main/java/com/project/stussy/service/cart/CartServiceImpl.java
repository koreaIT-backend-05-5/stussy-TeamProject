package com.project.stussy.service.cart;


import org.springframework.stereotype.Service;

import com.project.stussy.domain.cart.Cart;
import com.project.stussy.domain.cart.CartRepository;
import com.project.stussy.web.dto.cart.AddCartReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
	
	private final CartRepository cartRepository ;
	
	//<<<장바구니 등록>>>
	@Override
	public int addCart(AddCartReqDto addCartReqDto) throws Exception {
		Cart cart = addCartReqDto.toCartEntity();
		
		cartRepository.saveCart(cart);
		
		return 0;
	}


}
	

