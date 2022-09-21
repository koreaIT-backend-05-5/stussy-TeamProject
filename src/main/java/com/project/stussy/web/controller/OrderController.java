package com.project.stussy.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.stussy.service.cart.CartService;
import com.project.stussy.service.order.OrderServiceImpl;
import com.project.stussy.web.dto.CartOrderDto;
import com.project.stussy.web.dto.OrderDto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderServiceImpl orderServiceImpl;
	
	//여러개 주문시 주문정보 - 장바구니에서 주문하는 경우 
	@PostMapping("/multiple")
	public ModelAndView order(CartOrderDto cartOrderDto, Principal principal, HttpSession httpSession) {
		try {
			OrderDto orderDto = orderServiceImpl.orderList(cartOrderDto.getList(), principal.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		httpSession.setAttribute("dto", cartOrderDto); 
		return new ModelAndView("order/view").addObject("order", cartOrderDto);
	}
	
	@GetMapping("/list")
	public void list(Model model, Principal principal) {
		try {
			model.addAttribute("list", orderServiceImpl.readAll(principal.getName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}

