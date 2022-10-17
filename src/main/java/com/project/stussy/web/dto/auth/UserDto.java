package com.project.stussy.web.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

	private int userCode;
	private String userName;
	private String userEmail;
	private String userPassword;

}
