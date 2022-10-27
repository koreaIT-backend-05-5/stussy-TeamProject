package com.project.stussy.service.cart;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.stussy.domain.cart.Cart;
import com.project.stussy.domain.cart.CartRepository;
import com.project.stussy.web.dto.cart.AddCartReqDto;
import com.project.stussy.web.dto.cart.ReadUserCartRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
	
	private final CartRepository cartRepository ;
	
	//장바구니 상품 등록
	@Override
	public boolean addCart(AddCartReqDto addCartReqDto) throws Exception {
		Cart cart = addCartReqDto.toCartEntity();
		
		
		// userCode와 productCode로 cart_mst에 select 먼저 하고
		// 반환 결과가 null 이면 insert null 아니면 400에러
		cart = getCart(cart);
		
		return cart == null;
	}
	
	//장바구니 동일 상품 체크
	public Cart getCart(Cart cart) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product_code", cart.getProduct_code());
		map.put("user_code", cart.getUser_code());
		map.put("bag_product_size", cart.getBag_product_size());
		
		Cart tempCart = cartRepository.getCart(map);
		
		
		if(tempCart == null) {
			cartRepository.saveCart(cart);
			
		}
		return tempCart;
	}

	//장바구니 상품 리스트 
	@Override
	public List<ReadUserCartRespDto> getCartList(int userCode) throws Exception {
		List<Cart> cartList = null;
		List<ReadUserCartRespDto> cartDtoList = null;

		cartList = cartRepository.getCartList(userCode);
		
		cartDtoList = new ArrayList<ReadUserCartRespDto>();
		if(cartList != null) {
			for(int i = 0; i < cartList.size(); i++) {
				cartDtoList.add(cartList.get(i).toReadUserCartRespDto());
			}
		}
		return cartDtoList;
	}

	//장바구니 상품 수량 수정
	@Override
	public int updateAmount(int cartCode, int amount) throws Exception {
		return cartRepository.updateAmount(cartCode, amount);
	}

	//장바구니 상품 삭제
	@Override
	public boolean deleteCart(int cart_code) throws Exception {
		
		return cartRepository.deleteCart(cart_code) > 0;
	}
}
	

