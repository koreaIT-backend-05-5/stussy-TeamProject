package com.project.stussy.web.dto.product;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.project.stussy.domain.product.Product;

import lombok.Data;

@Data
public class AddProductReqDto {
	
	private int productCode;
	private int categoryCode;
	
	@NotBlank(message = "빈 값일 수 없습니다.")
	private String productName;
	
	@Max(value = 1000000, message = "최대 금액은 100만원 까지만 설정 가능합니다.")
    @Min(value = 100, message = "최소 금액은 100원입니다.")
	private String productPrice;
	private String productCount;
	
	@NotBlank(message = "빈 값일 수 없습니다.")
	private String productInfo;

	private String productSize;
    
	private List<MultipartFile> file;
	
	//entity
		public Product toProductEntity() {
			 return Product.builder()
				.product_code(getProductCode())
				.category_code(getCategoryCode())
				.product_name(getProductName())
				.product_price(getProductPrice())
				.product_count(getProductCount())
				.product_size(getProductSize())
				.product_info(getProductInfo())
				.build();


		}
}
