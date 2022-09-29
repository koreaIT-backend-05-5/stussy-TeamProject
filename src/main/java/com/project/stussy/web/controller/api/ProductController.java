package com.project.stussy.web.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stussy.service.product.ProductService;
import com.project.stussy.web.dto.CMRespDto;
import com.project.stussy.web.dto.product.AddProductReqDto;
import com.project.stussy.web.dto.product.GetProductListDto;
import com.project.stussy.web.dto.product.GetProductResponesDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/manager")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
	
	private final ProductService productService;
	
	//상품,이미지 등록
	@PostMapping("")
	public ResponseEntity<?> addProduct(AddProductReqDto addProductReqDto) {
		
		log.info(">>>>> {}", addProductReqDto);
		log.info(">>>>> {}", addProductReqDto.getFile().get(0).getOriginalFilename());
		int productCode = 0;
		
		try {
			productCode = productService.addProduct(addProductReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "add Failed", productService));
		}
		
		return ResponseEntity.ok(new CMRespDto<>(1, "completing add", productCode));
	}
	
	//모든 상품 조회
	@GetMapping("/product-list/{page}")
	public ResponseEntity<?> getProductLsit(@PathVariable int page) {
		List<GetProductListDto> listDto = null;
		
		try {
			listDto = productService.getProductList(page);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1,"database error",listDto));

		}
		return ResponseEntity.ok(new CMRespDto<>(1,"lookup successful", listDto));
	}
	
//	@GetMapping("/{flag}/{productCode}")
//	public ResponseEntity<?> getProduct(@PathVariable String flag, @PathVariable int productCode) {
//		GetProductResponesDto getProductResponesDto = null;
//		if(flag.equals("pre") || flag.equals("next")) {
//			try {
//				getProductResponesDto = productService.getProduct(flag, productCode);
//			} catch (Exception e) {
//				e.printStackTrace();
//				return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
//			}
//		}else {
//			return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
//		}
//		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", getProductResponesDto));
//	}
//	
	
	
	//DB에서 수정 할 상품정보 가져오는 API
	@GetMapping("/product-detail/{productCode}")
	public ResponseEntity<?> getProductDetail(@PathVariable int productCode) {
		GetProductResponesDto getProductResponesDto = null;
		try {
			getProductResponesDto = productService.getProductDetail(productCode);
			if(getProductResponesDto == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
			}
		} catch (Exception e) {
			e.printStackTrace();
				return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", getProductResponesDto));
	}
	
	//상품 수정
	@PutMapping("/product-modify/{productCode}") //@RequestBody: JSON으로 받아올 수 없다.
	public ResponseEntity<?> updateProduct(@PathVariable int productCode, GetProductResponesDto getProductResponesDto) {
		boolean status = false;
		try {
			getProductResponesDto.setProductCode(productCode);
			System.out.println(getProductResponesDto);
			status = productService.updateProduct(getProductResponesDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failed", status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", status));
	}
	
	//상품 삭제
	@DeleteMapping("/product-list/{productCode}")
	public ResponseEntity<?> deleteProduct(@PathVariable int productCode){
		boolean status = false;
		try {
			status = productService.deleteProduct(productCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failed", status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", status));
	}

}
