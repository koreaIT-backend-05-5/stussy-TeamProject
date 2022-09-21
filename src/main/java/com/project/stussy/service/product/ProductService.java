package com.project.stussy.service.product;

import java.util.List;

import com.project.stussy.web.dto.product.AddProductReqDto;
import com.project.stussy.web.dto.product.GetProductListResponseDto;
import com.project.stussy.web.dto.product.GetProductReqDto;

public interface ProductService {
	public List<GetProductListResponseDto> getNoticeList(int page) throws Exception;
	public int addProduct(AddProductReqDto addProductReqDto) throws Exception;
	public GetProductListResponseDto getProduct(String flag, int productCode) throws Exception;

}
