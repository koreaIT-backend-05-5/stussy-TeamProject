package com.project.stussy.domain.account.addresses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Addresses {
	private int info_code;
	private int user_code;
	private String road_address;
	private String building_name;
	private String si_do;
	private String zone_code;
}
