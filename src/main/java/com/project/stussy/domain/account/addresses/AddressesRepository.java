package com.project.stussy.domain.account.addresses;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressesRepository {
	
	// 주소 추가
	public int saveAddresses(Addresses addresses) throws Exception;
}
