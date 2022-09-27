package com.project.stussy.service.product;

import java.util.List;

import com.project.stussy.web.dto.product.AddProductReqDto;
import com.project.stussy.web.dto.product.GetProductListDto;
import com.project.stussy.web.dto.product.GetProductResponesDto;
import com.project.stussy.web.dto.product.ProductMainRepDto;

public interface ProductService {
	//등록
	public int addProduct(AddProductReqDto addProductReqDto) throws Exception;
	
	//조회
	public List<GetProductListDto> getProductList(int page) throws Exception;
		
	//
	public GetProductResponesDto getProduct(String flag, int noticeCode) throws Exception;
	
	//shop페이지 조회
	


}
