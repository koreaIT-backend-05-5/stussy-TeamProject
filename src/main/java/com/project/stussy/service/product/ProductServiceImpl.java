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
import com.project.stussy.web.dto.product.GetShopListRepDto;
import com.project.stussy.web.dto.product.GetDetailRepDto;
import com.project.stussy.web.dto.product.GetProductListDto;
import com.project.stussy.web.dto.product.GetProductResponesDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	
	//<<파일 업로드 할 주소>>
	@Value("${file.path}")
	private String filePath;
	
	private final ProductRepository productRepository;
	
	//<<<상품 등록>>>
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
	
	//<<<상품 조회>>>
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

	//<<<상품 수정>>>
	//1. 수정 할 상품 조회
	@Override
	public GetProductResponesDto getProductDetail(int productCode) throws Exception {
		Product productEntity = null;
		GetProductResponesDto productResponesDto = null;
		
		productEntity = productRepository.getProductDetail(productCode);
		
		if(productEntity != null) {
			productResponesDto = productEntity.toReqDto();
		}
		
		return productResponesDto;
	}
	
	//2. 상품 수정
	@Override
	public boolean updateProduct(GetProductResponesDto getProductResponesDto) throws Exception {
		Product productEntity = getProductResponesDto.toEntity();
		
		//공백이 아닐때만 if문 실행해서 폴더에 사진 업로드 해줍니다.
		if(!getProductResponesDto.getFile().getOriginalFilename().isBlank()) {
			String path = filePath + "product";
			Path uploadPath = Paths.get(filePath, "product/" + productEntity.getFile_name());
			
			File f = new File(path);
			
			if(!f.exists()) {
				f.mkdirs();
			}
			
			System.out.println(productEntity);
			
			Files.write(uploadPath, getProductResponesDto.getFile().getBytes());
		}
		
		return productRepository.updateProduct(productEntity) > 0;
	}		
	
	//<<삭제>>
	@Override
	public boolean deleteProduct(int productCode) throws Exception {
		
		return productRepository.deleteProduct(productCode) > 0;
	}

//=========================================================================================================

	//shop detail
	@Override
	public GetDetailRepDto getDetail(String flag, int productCode) throws Exception {
		GetDetailRepDto getDetailRepDto = null;
		
		Map<String, Object> mainmap = new HashMap<String, Object>();
		mainmap.put("flag", flag); 
		mainmap.put("product_code", productCode); 
		
		List<Product> productMain = productRepository.getProductDetailList(mainmap);
		log.info("{}", productMain);
		if(!productMain.isEmpty()) {
			List<Map<String, Object>> downloadFiles = new ArrayList<Map<String, Object>>();
			productMain.forEach(product -> {
				Map<String, Object> fileMap = new HashMap<String, Object>(); 
				fileMap.put("fileCode", product.getFile_code());
				
				String fileName = product.getFile_name(); 
				fileMap.put("fileName", fileName.substring(fileName.indexOf("_") + 1));
				
				downloadFiles.add(fileMap);
			});
			
			Product firstProduct = productMain.get(0);
			
			getDetailRepDto = GetDetailRepDto.builder()
					.productCode(firstProduct.getProduct_code())
					.productName(firstProduct.getProduct_name())
					.productPrice(firstProduct.getProduct_price())
					.productSize(firstProduct.getProduct_size())
					.productExplanation(firstProduct.getProduct_explanation())
					.fileName(firstProduct.getFile_name())
					.build();
		}
		
		return getDetailRepDto; 
	}

	//shopMain
	@Override
	public List<GetShopListRepDto> getShopList(int page, int contentCount, int categoryCode) throws Exception {
		int index = (page - 1) * 10;
		
		
		List<GetShopListRepDto> list = new ArrayList<GetShopListRepDto>();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("index", index);
		map.put("contentCount", contentCount);
		map.put("category_code", categoryCode);
		
		productRepository.getProductShopList(map).forEach(product -> {
			list.add(product.toShopListDto()); 
		});
		
		return list;
	}


}
	

