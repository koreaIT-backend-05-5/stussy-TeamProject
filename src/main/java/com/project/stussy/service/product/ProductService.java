package com.project.stussy.service.product;

import java.util.List;

import com.project.stussy.web.dto.product.AddProductReqDto;
import com.project.stussy.web.dto.product.GetProductListDto;
import com.project.stussy.web.dto.product.GetProductResponesDto;

public interface ProductService {
	//<<등록>>
	public int addProduct(AddProductReqDto addProductReqDto) throws Exception;
	
	//<<조회>>
	//1. 상품 리스트 조회
	public List<GetProductListDto> getProductList(int page) throws Exception;
	//2. 수정 할 상품 조회
	public GetProductResponesDto getProductDetail(int productCode) throws Exception;

	//<<수정>>
	public boolean updateProduct(GetProductResponesDto getProductResponesDto) throws Exception;
	
	//<<삭제>>
	public boolean deleteProduct(int productCode) throws Exception;




	
	
	
	
	
//	public GetProductResponesDto getProduct(String flag, int productCode) throws Exception;
//	
//	
//	public List<GetProductListDto> getProductDetail(int productCode) throws Exception;
 

	
	
	
}
