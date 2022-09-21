package com.project.stussy.service.order;

import java.util.List;

import com.project.stussy.web.dto.OrderDto;
import com.project.stussy.web.dto.CartOrderDto.Param;

public interface OrderService {
	
	public void add() throws Exception; 
	
	public List<OrderDto> readAll(String user_email) throws Exception;
	
	public OrderDto orderOne(int product_imgcode, int user_code, String user_email) throws Exception;
	
	public OrderDto orderList(List<Param> list, String user_email) throws Exception; 
}
