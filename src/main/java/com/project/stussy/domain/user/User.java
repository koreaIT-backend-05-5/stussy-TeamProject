package com.project.stussy.domain.user;

import java.time.LocalDateTime;

public class User { //user entity - db와 1대1 맵핑
	private String user_name;
	private String user_email;
	private String user_password;
	private String user_roles;
	private int user_code;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
