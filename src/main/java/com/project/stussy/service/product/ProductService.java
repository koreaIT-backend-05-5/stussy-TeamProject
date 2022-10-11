package com.project.stussy.service.product;

import java.util.List;

import com.project.stussy.web.dto.product.AddProductReqDto;
import com.project.stussy.web.dto.product.GetShopListRepDto;

import lombok.Builder;
import lombok.Data;

import com.project.stussy.web.dto.product.GetProductListDto;
import com.project.stussy.web.dto.product.GetProductResponesDto;
import com.project.stussy.web.dto.product.GetDetailRepDto;

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

	//shop
	//shop detail 
	public GetDetailRepDto getDetail(String flag, int productCode) throws Exception; 
	//shop page

	public List<GetShopListRepDto> getShopList(int page, int contentCount, int categoryCode) throws Exception; 
	
	
}
