package com.project.stussy.exception;

import lombok.Getter;

@Getter
public class ProductValidationApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
		
	public ProductValidationApiException(String message) {
		super(message);
	}
	

}
