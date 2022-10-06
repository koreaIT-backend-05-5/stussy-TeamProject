package com.project.stussy.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stussy.domain.mall.Mail;
import com.project.stussy.service.mail.MailService;
import com.project.stussy.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class MailController {
	
	private final MailService mailService;
	
	@PostMapping("/findPassword")
	public ResponseEntity<?> sendMail(Mail mail) {
		try {
			mailService.sendMail(mail);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1,"failed", mail));
		}
		return ResponseEntity.ok(new CMRespDto<>(1,"success", mail));

	}
}
