package com.project.stussy.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetUserListDto {
	private int userCode; 
	private String userName;
	private String userEmail;
	private String userPhone;
	private String createDate;
	private int totalUserCount;
	
}
