package com.project.stussy.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stussy.service.account.addresses.AddressesService;
import com.project.stussy.web.dto.CMRespDto;
import com.project.stussy.web.dto.account.addresses.AddAddressesReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/account")
@Slf4j
@RequiredArgsConstructor
public class AccountRestController {
	
	private final AddressesService addressesService;
	
	@PostMapping("/addresses")
	public ResponseEntity<?> addAddress(@RequestBody AddAddressesReqDto addAddressesReqDto) {
		log.info(">>>>>> {}", addAddressesReqDto);
		
		int infoCode = 0;
		
		try {
			infoCode = addressesService.addAddresses(addAddressesReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failed", infoCode));
		}
		
		return ResponseEntity.ok(new CMRespDto<>(1, "success", infoCode));
	}
}
