package com.project.stussy.domain.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private int user_code;
	private String user_name;
	private String user_email;
	private String user_password;
	private String user_roles;
	private String user_address;
	private String user_phone;
	
	
	//ROLE_USER, ROLE_ADMIN...(쉼표마다 짤라 배열만들어주고 리스트로 만들어준다)
	public List<String> getUserRoles() {
		if(user_roles == null || user_roles.isBlank()) {
			return new ArrayList<String>();
		}
		
		return Arrays.asList(user_roles.replaceAll(" ", "").split(","));
		
	}
	
}
