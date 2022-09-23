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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	
	
	@Value("${file.path}")
	private String filePath;
	
	private final ProductRepository productRepository;

	@Override
	public int addProduct(AddProductReqDto addProductReqDto) throws Exception {
		//등록
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
		
		//파일등록
		if(predicate.test(addProductReqDto.getFile().get(0).getOriginalFilename())) {
			List<ProductFile> productFiles = new ArrayList<ProductFile>();			
			
			for(MultipartFile file : addProductReqDto.getFile()) {
				String originalFilename = file.getOriginalFilename();
				String tempFilename = UUID.randomUUID().toString().replace("-", "") + "_"+ originalFilename;
				log.info(tempFilename);
				Path uploadPath = Paths.get(filePath, "manager/" + tempFilename);
				
				File f = new File(filePath + "product");
				if(!f.exists()) {
					f.mkdir();
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

}
	

