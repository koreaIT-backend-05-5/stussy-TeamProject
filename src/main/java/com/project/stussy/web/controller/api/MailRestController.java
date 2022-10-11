package com.project.stussy.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stussy.domain.mail.Mail;

import com.project.stussy.service.mail.MailService;
import com.project.stussy.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
public class MailRestController {
	
	private final MailService mailService;
	
	// 문의사항 답변하기 메일 전송
	@PostMapping("")
	public ResponseEntity<?> contactSendMail(Mail mail){

		System.out.println(mail);
		
		try {
			mailService.sendMail(mail);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failed", mail));
		}
		return ResponseEntity.ok(new CMRespDto<>(1, "success", mail));
		
	}
	
	//임시비밀번호 발급
	@PostMapping("/random/password")
	public ResponseEntity<?> passowrdSendMail(String email){
		String randomPassword = null;
		
		try {
			randomPassword = mailService.getRamdomPassword(email);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failed", randomPassword));
		}
		return ResponseEntity.ok(new CMRespDto<>(1, "success", randomPassword));
		
	}
	

}
