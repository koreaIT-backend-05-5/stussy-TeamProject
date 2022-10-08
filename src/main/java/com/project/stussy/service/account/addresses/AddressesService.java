package com.project.stussy.service.account.addresses;

import com.project.stussy.web.dto.account.addresses.AddAddressesReqDto;

public interface AddressesService {
	
	// 주소 추가
	public int addAddresses(AddAddressesReqDto addAddressesReqDto) throws Exception;
}
