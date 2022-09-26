package com.project.stussy.service.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.project.stussy.domain.product.Product;
import com.project.stussy.domain.product.ProductRepository;
import com.project.stussy.web.dto.product.AddProductReqDto;
import com.project.stussy.web.dto.product.GetProductListDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;

	@Override
	public int addProduct(AddProductReqDto addProductReqDto) throws Exception {
		//상품 등록 
		Predicate<String> predicate = (filename) -> !filename.isBlank();
		Product product = null;
		
		product = Product.builder()
				.product_code(addProductReqDto.getProductCode())
				.product_category(addProductReqDto.getProductCategory())
				.product_name(addProductReqDto.getProductName())
				.product_price(addProductReqDto.getProductPrice())
				.product_explanation(addProductReqDto.getProductExplanation())
				.product_size(addProductReqDto.getProductSize())
				.build();
		
		productRepository.saveProduct(product);
		
		return product.getProduct_code();
	}

	@Override
	public List<GetProductListDto> getProductList(int page) throws Exception {
		int index = (page - 1) * 10;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("index", index);
		
		List<GetProductListDto> list = new ArrayList<GetProductListDto>();
		
		productRepository.getProductList(map).forEach(product -> {
			list.add(product.toListDto());
		});
		
		return list;
	}

	@Override
	public Product productView(String user_Email) throws Exception {
		
		return productRepository.findProductById(user_Email);
	}

}
