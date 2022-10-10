package com.project.stussy.web.controller.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PayMentPageController {
	//===========결제 관련 ===========//
	@GetMapping("/import")
	public String loadImport() {
		return "/import";
	}
	@GetMapping("/buy")
	public String loadBuy() {
		return "buy/buyPage";
	}
	@GetMapping("/checkouts")
	public String loadcheckouts() {
		return "checkouts/checkouts";
	}
	@GetMapping("/checkoutscard")
	public String loadcheckoutscard() {
		return "checkouts/checkouts_card";
	}
	@GetMapping("/cart")
	public String loadCart() {
		return "cart/cart";
	}
}
