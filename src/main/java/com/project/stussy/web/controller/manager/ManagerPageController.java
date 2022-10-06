package com.project.stussy.web.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/manager" })
public class ManagerPageController {

//====================문의사항=====================//	

	// 관리자 문의사항관리 페이지
	@GetMapping("/contact/list")
	public String ManagerContactList() {
		return "manager/manager-contact/manager-contact-list";
	}

	// 관리자 문의사항 답변하기 페이지
	@GetMapping("/detail/{contactCode}")
	public String ManagerContactDetail() {
		return "manager/manager-contact/manager-contact-detail";
	}
	@GetMapping("/manager-user")
	public String loadUserList() {
		return "manager/manager-user";
	}

	@GetMapping("/mail/send")
    public String dispMail() {
        return "mail/contact_mail_insert";
    }
	
//	@GetMapping("/product-update")
//	public String loadUpdateList() {
//		return "manager/product-update";
//	}
}

