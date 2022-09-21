package com.project.stussy.domain.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRepository {
	public int save(Order order);
	public List<Order> findByUsername(String user_name); 
}
