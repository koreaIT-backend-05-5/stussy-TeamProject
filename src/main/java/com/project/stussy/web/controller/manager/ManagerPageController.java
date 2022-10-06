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

	// ===========회원 관리 ===================//
	@GetMapping("/manager-user")
	public String loadUserList() {
		return "manager/manager-user";
	}

	// =================상품관련===================//
	/*
	 * @GetMapping("/product-update") public String loadProduct() { return
	 * "manager/product-update"; }
	 * 
	 * 
	 * @GetMapping("/product-list") public String loadProductList() { return
	 * "manager/product-list"; }
	 * 
	 * @GetMapping("/product-modify/{productCode}") public String
	 * loadProductModify() { return "manager/product-modify"; }
	 */
	/*
	 * @GetMapping("/product-list/{productCode}") public String loadProductDelete()
	 * { return "manager/product-list"; }
	 */

}
