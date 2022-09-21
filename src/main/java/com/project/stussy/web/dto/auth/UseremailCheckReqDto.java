package com.project.stussy.web.dto.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UseremailCheckReqDto {
	@NotBlank
	@Email
	private String useremail;
	
}
