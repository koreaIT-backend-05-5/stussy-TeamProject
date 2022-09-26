package com.project.stussy.service.product;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.stussy.domain.product.Product;
import com.project.stussy.domain.product.ProductFile;
import com.project.stussy.domain.product.ProductRepository;
import com.project.stussy.web.dto.product.AddProductReqDto;
import com.project.stussy.web.dto.product.GetProductListDto;
import com.project.stussy.web.dto.product.GetProductResponesDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	
	
	@Value("${file.path}")
	private String filePath;
	
	private final ProductRepository productRepository;
	
	//상품 등록
	@Override
	public int addProduct(AddProductReqDto addProductReqDto) throws Exception {
		
		Predicate<String> predicate = (filename) -> !filename.isBlank();
		
		Product product = null;
		
		
		product = Product.builder()
				.product_code(addProductReqDto.getProductCode())
				.product_category(addProductReqDto.getProductCategory())
				.product_name(addProductReqDto.getProductName())
				.product_price(addProductReqDto.getProductPrice())
				.product_size(addProductReqDto.getProductSize())
				.product_explanation(addProductReqDto.getProductExplanation())
				.build();
		
		productRepository.saveProduct(product);
		
		//파일등록
		if(predicate.test(addProductReqDto.getFile().get(0).getOriginalFilename())) {
			List<ProductFile> productFiles = new ArrayList<ProductFile>();			
			
			for(MultipartFile file : addProductReqDto.getFile()) {
				String originalFilename = file.getOriginalFilename();
				String tempFilename = UUID.randomUUID().toString().replace("-", "") + "_"+ originalFilename;
				log.info(tempFilename);
				Path uploadPath = Paths.get(filePath, "product/" + tempFilename);
				
				File f = new File(filePath + "product");
				if(!f.exists()) {
					f.mkdir(); // 폴더 만들기
				}
				
				try {
					Files.write(uploadPath, file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				productFiles.add(ProductFile.builder().product_code(product.getProduct_code()).file_name(tempFilename).build());
			
			}
			
			productRepository.saveProductFiles(productFiles);
			
		}
		
		return product.getProduct_code();
	}
	
	//상품 조회
	@Override
	public List<GetProductListDto> getProductList(int page) throws Exception {
		int index = (page - 1) * 10;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("index", index);
		
		 List<GetProductListDto> list = new ArrayList<GetProductListDto>();
		
		productRepository.getProductList(map).forEach(product -> {
			
			list.add(product.toListDto());
		});;
		return list;
	}


	@Override
	public GetProductResponesDto getProduct(String flag, int noticeCode) throws Exception {
		GetProductResponesDto getProductResponesDto = null;
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("flag", flag);
		reqMap.put("notice_code", noticeCode);
		
		productRepository.countIncrement(reqMap);
		List<Product> products = productRepository.getProductList(reqMap);

			
			Product firstProduct = products.get(0);
			
			getProductResponesDto = GetProductResponesDto.builder()
					.productCode(firstProduct.getProduct_code())
					.productCategory(firstProduct.getProduct_category())
					.productName(firstProduct.getProduct_name())
					.productPrice(firstProduct.getProduct_price())
					.productSize(firstProduct.getProduct_size())
					.productExplanation(firstProduct.getProduct_explanation())
					.productCount(firstProduct.getProduct_count())
					.build();
		
	return getProductResponesDto;
	}
		

}
	

