package com.project.stussy.service.cart;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.stussy.domain.cart.CartRepository;
import com.project.stussy.web.dto.CartDeleteDto;
import com.project.stussy.web.dto.CartDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
	
	private final CartRepository cartRepository;

	//장바구니 읽기
	@Override
	public List<CartDto> read(String user_email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(int cart_code, int cart_count, String user_email) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int decrease(int cart_code, String user_eamil) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(CartDeleteDto cartDeleteDto, String user_eamil) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
