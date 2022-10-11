package com.project.stussy.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class UserAddressPageController {
	
	//내 정보 페이지
	@GetMapping("/account/main")
	public String loadAccountPage() {
		return "account/account-main";
	}
	
	//주소수정, 추가, 삭제 페이지
	@GetMapping("/account/addresses")
	public String addressesInfo() {
		return "account/account_addresses";
	}
}
