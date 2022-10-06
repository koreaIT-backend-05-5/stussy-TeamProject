package com.project.stussy.domain.cart;

import com.project.stussy.domain.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItem {
	private String user_name;
	private Cart cart; 
	private Product product; 
	private int cart_count;
	
	public CartItem createCartItem(Cart cart, Product product) {
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		return cartItem; 
	} 
	
	public void addCount(int cartCount) {
		this.cart_count = cartCount;
	}
	
	
}
