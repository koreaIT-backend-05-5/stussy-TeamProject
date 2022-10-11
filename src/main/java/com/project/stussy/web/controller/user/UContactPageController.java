package com.project.stussy.web.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class UContactPageController {
	
	// 문의사항 작성 페이지
	@GetMapping("/addition")
	public String loadContactInsert() {
		return "contact/contact_insert";
	}
	
	@GetMapping("/addition/complete")
	public String ContactInsertComplete() {
		return "contact/contact_insert_complete";
	}



}
