package com.project.stussy.domain.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {
	
	//상품,이미지 등록
	public int saveProduct(Product product) throws Exception;
	public int saveProductFiles(List<ProductFile> list) throws Exception;
	
	//상품 조회
	public List<Product> getProductList(Map<String, Object> map) throws Exception;
	
	//상품 수정
	public int countIncrement(Map<String, Object> map) throws Exception;


	
}
