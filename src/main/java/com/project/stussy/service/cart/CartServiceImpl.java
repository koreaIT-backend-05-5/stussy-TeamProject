package com.project.stussy.service.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.stussy.domain.cart.Cart;
import com.project.stussy.domain.cart.CartItem;
import com.project.stussy.domain.cart.CartRepository;
import com.project.stussy.domain.product.Product;
import com.project.stussy.domain.product.ProductRepository;
import com.project.stussy.web.dto.cart.AddCartReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {
	
	private final CartRepository cartRepository; 
	private final ProductRepository productRepository; 
	
	@Override
	public List<AddCartReqDto> read(String userEmail, int productCode) throws Exception {
		List<CartItem> cartItems = cartRepository.findByUserName(userEmail, productCode);
		List<AddCartReqDto> addCartReqDtos = new ArrayList<>();
		for(CartItem cartItem : cartItems) {
			Product p = productRepository.getProductDetailList(cartItem.getProduct());
			
		}
		return null;
	}

	@Override
	public boolean add(int productCode, int count, String userEmail) throws Exception {
		CartItem cartItem = cartRepository.findByUserName(userEmail, p)
		return false;
	}

	@Override
	public int increase(int productCode, String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int decrease(int productCode, String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(List<Integer> prdouctCodes, String userEmail) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	private final CartRepository cartRepository; 

	@Override
	public AddCartReqDto getCart(int productCode) throws Exception {
		AddCartReqDto addCartReqDto = null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product_code", productCode);
		
		List<Cart> cartList = cartRepository.getCartList(map);
		if(!cartList.isEmpty()) {
			List<Map<String, Object>> downloadFiles	= new ArrayList<Map<String, Object>>();
			cartList.forEach(cart -> {
				Map<String, Object> fileMap = new HashMap<String, Object>();
				fileMap.put("fileCode", cart.getFile_code());
				
				String fileName = cart.getFile_name();
				fileMap.put("fileName", fileName.substring(fileName.indexOf("_") + 1));
				
				downloadFiles.add(fileMap);
				
			});
			
			Cart firstCart = cartList.get(0); 
			
			addCartReqDto  = AddCartReqDto.builder()
					.productCode(firstCart.getProduct_code())
					.userEmail(firstCart.getUser_email())
					.cartCode(firstCart.getCart_code())
					.cartCount(firstCart.getCart_count())
					.cartTotalPrice(firstCart.getCart_total_price())
					.productName(firstCart.getProduct_name())
					.productPrice(firstCart.getProduct_price())
					.fileCode(firstCart.getFile_code())
					.fileName(firstCart.getFile_name())
					.build();
					
		}
		
		return addCartReqDto;
	}
	*/

}
