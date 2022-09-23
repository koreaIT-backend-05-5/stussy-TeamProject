package com.project.stussy.service.product;

import java.util.List;

import com.project.stussy.web.dto.product.AddProductReqDto;
import com.project.stussy.web.dto.product.GetProductListDto;

public interface ProductService {
	//등록
	public int addProduct(AddProductReqDto addProductReqDto) throws Exception;
	
	//조회
	public List<GetProductListDto> getProductList(int page) throws Exception;
}
