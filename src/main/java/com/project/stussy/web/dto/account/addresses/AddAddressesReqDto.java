package com.project.stussy.web.dto.account.addresses;

import lombok.Data;

@Data
public class AddAddressesReqDto {
	private int infoCode;
	private int userCode;
	private String roadAddress;
	private String buildingName;
	private String siDo;
	private String zoneCode;
}
