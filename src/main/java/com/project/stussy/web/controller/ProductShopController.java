package com.project.stussy.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.stussy.service.product.ProductService;
import com.project.stussy.web.dto.CMRespDto;
import com.project.stussy.web.dto.product.GetDetailRepDto;
import com.project.stussy.web.dto.product.GetShopListRepDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductShopController {
	
	private final ProductService productService;
	
	//shop페이지의 list 
	@GetMapping("/list/{page}")
	public ResponseEntity<?> getShopList(@PathVariable int page, int contentCount, int categoryCode) {
//		@RequestParam String searchFlag, @RequestParam String searchValue
		
		System.out.println(categoryCode);
		List<GetShopListRepDto> shopListDto = null; 
		try {
			shopListDto = productService.getShopList(page, contentCount, categoryCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", shopListDto)); 
		}
		return ResponseEntity.ok(new CMRespDto<>(1, "lookup successful", shopListDto)); 
	}
	
	@GetMapping("/{productCode}")
	public ResponseEntity<?> getMainList(@PathVariable int productCode) {
		GetDetailRepDto getMainRepDto = null; 
        try {
			getMainRepDto = productService.getDetail(null, productCode);
			if(getMainRepDto == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "requset failed", null));
			}
		} catch (Exception e) { 
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		}	
        return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", getMainRepDto));
	}
	
	@GetMapping("/{productCode}/{flag}")
	public ResponseEntity<?> getMainList(@PathVariable String flag, @PathVariable int productCode) {
		GetDetailRepDto getMainRepDto = null; 
		if(flag.equals("pre") || flag.equals("next")) {
			try {
				getMainRepDto = productService.getDetail(null, productCode);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", getMainRepDto));
	}
}
