package com.project.stussy.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping({"/contact"})
public class ContactPageController {
	
	// 문의사항 작성 페이지
	@GetMapping("/addition")
	public String loadContactInsert() {
		return "contact/contact_insert";
	}
	
	@GetMapping("/addition/complete")
	public String ContactInsertComplete() {
		return "contact/contact_insert_complete";
	}
	
//============================관리자 문의사항 페이지============================//
	
	// 문의사항 홈
	@GetMapping("/manager/list")
	public String loadContactList() {
		return "contact/contact_list";
	}
	

	// 문의사항 상세 페이지
	@GetMapping("/manager/view/{contactCode}")
	public String loadContactView() {
		return "contact/contact_view";
	}
	
	// 문의사항 수정 페이지
	@GetMapping("/manager/modify/{contactCode}")
	public String loadContactModify() {
		return "contact/contact_modify";
	}


}
