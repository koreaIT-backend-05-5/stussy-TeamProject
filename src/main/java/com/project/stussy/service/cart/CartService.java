package com.project.stussy.service.cart;

import java.util.List;

import com.project.stussy.web.dto.cart.AddCartReqDto;

public interface CartService {

	//읽기
	public List<AddCartReqDto> read(String userEmail, int productCode) throws Exception;
	
	//추가
	public boolean add(int productCode, int count, String userEmail) throws Exception;
	
	//증가
	public int increase(int productCode, String userEmail) throws Exception;
	
	//감소
	public int decrease(int productCode, String userEmail) throws Exception;
	
	//삭제
	public void delete(List<Integer> prdouctCodes, String userEmail) throws Exception;
}
