package com.project.stussy.web.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stussy.service.auth.AuthService;
import com.project.stussy.service.auth.PrincipalDetails;
import com.project.stussy.service.auth.PrincipalDetailsService;
import com.project.stussy.web.dto.CMRespDto;
import com.project.stussy.web.dto.auth.SignupReqDto;
import com.project.stussy.web.dto.auth.UseremailCheckReqDto;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final PrincipalDetailsService principalDetailsService;
	private final AuthService authService;
	
	//이메일 체크
	@GetMapping("/signup/validation/useremail")
	public ResponseEntity<?> checkUseremail(@Valid UseremailCheckReqDto useremailCheckReqDto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMessage = new HashMap<String, String>();
			
			bindingResult.getFieldErrors().forEach(error -> {
				errorMessage.put(error.getField(), error.getDefaultMessage());
			});
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMessage));
		}
		boolean status = false;
		
		try {
			status = authService.checkUseremail(useremailCheckReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "서버 오류", status));
		}
		
	return ResponseEntity.ok(new CMRespDto<>(1, "회원가입 가능여부", status));
}
	
	//회원가입
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupReqDto signupReqDto, BindingResult bindingResult) {
		boolean status = false;
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMessage = new HashMap<String, String>();
			
			bindingResult.getFieldErrors().forEach(error -> {
				errorMessage.put(error.getField(), error.getDefaultMessage());
			});
			
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMessage));
			
		}
		
		try {
			status = principalDetailsService.addUser(signupReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "회원가입 실패",status));
		}
		
		return ResponseEntity.ok(new CMRespDto<>(1, "회원가입 성공",status));

	}
	
	@GetMapping("/principal")
	public ResponseEntity<?> getPrincipal(@AuthenticationPrincipal PrincipalDetails principalDetails){
		if(principalDetails == null) {
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1,"principal is null", null));
		}
		return ResponseEntity.ok(new CMRespDto<>(1,"success load", principalDetails.getUser()));
	}
	

}
