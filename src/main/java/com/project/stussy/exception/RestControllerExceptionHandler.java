package com.project.stussy.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.stussy.web.dto.CMRespDto;

@RestControllerAdvice
public class RestControllerExceptionHandler {
															//.class: 해당 클래스 타입을 말한다.
	@ExceptionHandler(ProductValidationApiException.class) 	//CustomValidationApiException에 만들어 놓은 예외를 받겠다.
	public ResponseEntity<?> validationApException(ProductValidationApiException e){
		System.out.println("들어옴");
		return ResponseEntity.badRequest().body(new CMRespDto<>(-1,e.getMessage(), null));
	}
}
