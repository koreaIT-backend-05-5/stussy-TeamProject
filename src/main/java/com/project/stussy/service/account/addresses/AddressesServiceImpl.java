package com.project.stussy.service.account.addresses; 

import org.springframework.stereotype.Service;

import com.project.stussy.domain.account.addresses.Addresses;
import com.project.stussy.domain.account.addresses.AddressesRepository;
import com.project.stussy.web.dto.account.addresses.AddAddressesReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressesServiceImpl implements AddressesService{
	
	private final AddressesRepository addressesRepository;
	
	// 주소 추가
	@Override
	public int addAddresses(AddAddressesReqDto addAddressesReqDto) throws Exception {
		
		Addresses addresses = null;
		
		addresses = Addresses.builder()
							.info_code(addAddressesReqDto.getInfoCode())
							.user_code(addAddressesReqDto.getUserCode())
							.road_address(addAddressesReqDto.getRoadAddress())
							.building_name(addAddressesReqDto.getBuildingName())
							.si_do(addAddressesReqDto.getSiDo())
							.zone_code(addAddressesReqDto.getZoneCode())
							.build();
		
		addressesRepository.saveAddresses(addresses);
							
		
		return addresses.getInfo_code();
	}
}
