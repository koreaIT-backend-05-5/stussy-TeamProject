package com.project.stussy.service.product;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.stussy.domain.product.ProductRepository;
import com.project.stussy.web.dto.product.AddProductReqDto;
import com.project.stussy.web.dto.product.GetProductListResponseDto;
import com.project.stussy.web.dto.product.GetProductReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	
	private final ProductRepository productRepository;
	
	@Value("${file.path}")
	private String filePath;
	
	@Override
	public int addProduct(AddProductReqDto addProductReqDto) throws Exception {
		Predicate<String> predicate = (filename) -> filename.isBlank();
		
		
		if(predicate.test(addProductReqDto.getFile().get(0).getOriginalFilename())) {
			
		}else {
			addProductReqDto.getFile().forEach(file -> {
				String originalFilename = file.getOriginalFilename();
				String tempFilename = UUID.randomUUID().toString().replaceAll("-", "") + "_" + originalFilename;
				log.info(tempFilename);
				Path uploadPath = Paths.get(filePath, "product/" + tempFilename);
				
				File f = new File(filePath + "product");
				if(!f.exists()) {
					f.mkdir();
				}
				
				try {
					Files.write(uploadPath, file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
		}
		return 0;
	}


//	@Override
//	public int addProduct(GetProductReqDto getProductReqDto) throws Exception {
//		// TODO Auto-generated method stub
//		return productRepository.SaveProduct(getProductReqDto.toEntity());
//	}


	@Override
	public List<GetProductListResponseDto> getNoticeList(int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetProductListResponseDto getProduct(String flag, int productCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




	
	
	
}




