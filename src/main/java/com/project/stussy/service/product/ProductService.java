package com.project.stussy.service.product;

import java.util.List;

import com.project.stussy.domain.product.Product;
import com.project.stussy.web.dto.product.AddProductReqDto;
import com.project.stussy.web.dto.product.GetProductListDto;

public interface ProductService {
	//등록
	public int addProduct(AddProductReqDto addProductReqDto) throws Exception;
	
	//조회
	public List<GetProductListDto> getProductList(int page) throws Exception;
	
	//상품 개별 불러오기 
	public Product productView(String user_Email) throws Exception; 
}
