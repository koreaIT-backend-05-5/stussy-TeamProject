package com.project.stussy.web.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class UserContactPageController {
	
	
	// 문의사항 작성 페이지
	@GetMapping("/addition")
	public String loadContactInsert() {
		return "contact/contact_insert";
	}
	
	// 문의사항 작성 성공 페이이지
	@GetMapping("/addition/complete")
	public String ContactInsertComplete() {
		return "contact/contact_insert_complete";
	}
	
	// 문의사항 답변하기
	@GetMapping("/mail/send")
	public String sendMail() {
		return "mail/contact_mail_insert";
	}
	
	

}
