package com.project.stussy.domain.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {
	
	public int SaveProduct(Product product) throws Exception;
	public int saveProductFiles(List<ProductFile> list) throws Exception;
	
	public List<Product> getProduct(Map<String, Object> map) throws Exception;
	public List<Product> getProductList(Map<String, Object> map) throws Exception;

}
