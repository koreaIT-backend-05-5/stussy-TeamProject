package com.project.stussy.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stussy.service.product.ProductService;
import com.project.stussy.web.dto.CMRespDto;
import com.project.stussy.web.dto.product.AddProductReqDto;
import com.project.stussy.web.dto.product.GetProductReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/manager")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
	
	private final ProductService productService;
	
	@PostMapping("")
	public ResponseEntity<?> addProduct(AddProductReqDto addProductReqDto) {
		log.info(">>>>> {}", addProductReqDto);
		log.info(">>>>> fileName: {}", addProductReqDto.getFile().get(0).getOriginalFilename());
		
		
		int productCode = 0;
		
		try {
			productCode = productService.addProduct(addProductReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Failed", productCode));
		}
		
		return ResponseEntity.ok(new CMRespDto<>(1, "completing add", productCode));
	}
	
	
	
//	@PostMapping("/update-product")
//	public ResponseEntity<?> addProduct(@RequestBody GetProductReqDto getProductReqDto) {
//		
//		int productCode = 0;
//		
//		try {
//			productCode = productService.addProduct(getProductReqDto);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "add Failed", productService));
//		}
//		
//		return ResponseEntity.ok(new CMRespDto<>(1, "completing add", productCode));
//	}
}
