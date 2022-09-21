package com.project.stussy.web.dto.auth;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.stussy.domain.user.User;

import lombok.Data;

@Data
public class SignupReqDto {
	@NotBlank
	@Pattern(regexp = "^[가-힇]*$", message = "한글만 입력 가능합니다.")
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	
	@NotBlank
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[-~!@#$%^&*_+=])[a-zA-Z\\d-~!@#$%^&*_+=]{8,16}$")
	private String password;
	
	@AssertTrue(message = "이메일 중복확인이 되지 않았습니다.")
	private boolean checkUseremailFlag;
	
	public User toEntity() {
		return User.builder()
				.user_name(name)
				.user_email(email)
				.user_password(new BCryptPasswordEncoder().encode(password))
				.user_roles("ROLE_USER")
				.build();
	}
}
