package com.project.stussy.domain.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {

	//상품 등록
	public int saveProduct(Product product) throws Exception;
	
	//이미지 등록
	public int saveProductFiles(List<ProductFile> list) throws Exception; 

	//상품 리스트 가져오기 
	public List<Product> getProduct(Map<String, Object> map) throws Exception;
	
	public List<Product> getProductList(Map<String, Object> map) throws Exception;
	
}
