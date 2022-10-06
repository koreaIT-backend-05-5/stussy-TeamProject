package com.project.stussy.web.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/manager"})
public class ManagerPageController {
	// 문의사항 답변하기 페이지 불러오기
		@GetMapping("/mail/send")
	    public String dispMail() {
	        return "mail/contact_mail_insert";
	    }
}
