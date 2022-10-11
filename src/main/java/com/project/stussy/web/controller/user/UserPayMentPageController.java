package com.project.stussy.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class UserPayMentPageController {
	
	//===========결제 관련 ===========//
	@GetMapping("/import")
	public String loadImport() {
		return "/import";
	}
	
	//결제 정보 페이지
	@GetMapping("/buy")
	public String loadBuy() {
		return "buy/buyPage";
	}
	
	//?위에랑 같은 페이지
	@GetMapping("/checkouts")
	public String loadcheckouts() {
		return "checkouts/checkouts";
	}
	
	//상세 결제 페이지
	@GetMapping("/checkoutscard")
	public String loadcheckoutscard() {
		return "checkouts/checkouts_card";
	}
	
	//장바구니 페이지
	@GetMapping("/cart")
	public String loadCart() {
		return "cart/cart";
	}
}
