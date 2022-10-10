package com.project.stussy.web.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ContactPageController {

//============================관리자 문의사항 페이지============================//
		// 문의사항 홈
		@GetMapping("/contact/list")
		public String loadContactList() {
			return "contact/contact_list";
		}
		// 문의사항 상세 페이지
		@GetMapping("/contact/view/{contactCode}")
		public String loadContactView() {
			return "contact/contact_view";
		}
		
}

