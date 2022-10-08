package com.project.stussy.service.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.project.stussy.domain.cart.Cart;
import com.project.stussy.domain.cart.CartRepository;
import com.project.stussy.web.dto.cart.AddCartReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {
	
	private final CartRepository cartRepository; 

	@Override
	public List<AddCartReqDto> getCartList(int page) throws Exception {
		int index = (page - 1) * 10;
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("index", index); 
		
		List<AddCartReqDto> cartList = new ArrayList<AddCartReqDto>(); 
		
		cartRepository.getCartList(map).forEach(cart -> {
			cartList.add(cart.toCartDto()); 
		});
		return cartList; 
	}

	@Override
	public boolean removeCart(int productCode) throws Exception {	
		return cartRepository.remove(productCode) > 0;
	}

	@Override
	public int addCart(AddCartReqDto addCartReqDto) throws Exception {
		Cart getCart = null;
		
		getCart = cartRepository.checkCart(addCartReqDto); 
		
		
		return 0;
	}

}
