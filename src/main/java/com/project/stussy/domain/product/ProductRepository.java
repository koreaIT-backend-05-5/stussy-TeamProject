package com.project.stussy.domain.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {
	
	//상품,이미지 등록
	public int saveProduct(Product product) throws Exception;
	public int saveProductFiles(List<ProductFile> list) throws Exception;
	
	//<<조회>>
	//1. 상품 조회
	public List<Product> getProductList(Map<String, Object> map) throws Exception;

	//2. 수정 할 상품 조회
	public Product getProductDetail(int product_code) throws Exception;
	
	//상품 수정
	public Product updateProduct(int product_code) throws Exception;
	
	//shop
	//상품 디테일페이지 
	public List<Product> getProductDetailList(Map<String, Object> map) throws Exception; 
	//shop페이지 조회
	public List<Product> getProductShopList(Map<String, Integer> map) throws Exception; 
	

}
