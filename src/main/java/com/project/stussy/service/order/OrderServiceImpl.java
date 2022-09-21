package com.project.stussy.service.order;

import java.util.ArrayList;
import java.util.List;

import com.project.stussy.web.dto.CartOrderDto.Param;
import com.project.stussy.domain.order.Order;
import com.project.stussy.domain.order.OrderRepository;
import com.project.stussy.web.dto.OrderDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;

	@Override
	public void add() throws Exception {
		// TODO Auto-generated method stub
		
	}

	//나의 주문정보 
	@Override
	public List<OrderDto> readAll(String user_email) throws Exception {
		List<Order> list = orderRepository.findByUsername(user_email);
		List<OrderDto> orderDtos = new ArrayList<>();
		for(Order order : list) {
			OrderDto dto = order.toOrderDto();
			//주문정보 기준을 잡을 한가지 변수를 선택하자 
			Address address = addressRepository.findByUsernameAddressNo(user_email, order.get);
			dto.set
		}
		return null;
	}

	//내가 주문한 물품 정보 
	@Override
	public OrderDto orderOne(int product_imgcode, int user_code, String user_email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDto orderList(List<Param> list, String user_email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
