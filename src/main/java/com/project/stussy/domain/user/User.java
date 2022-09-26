package com.project.stussy.domain.user;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User { //user entity - db와 1대1 맵핑
	private int user_code;
	private String user_name;
	private String user_email;
	private String user_password;
	private String user_roles;
	private String user_address;
	private String user_phone; 
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
