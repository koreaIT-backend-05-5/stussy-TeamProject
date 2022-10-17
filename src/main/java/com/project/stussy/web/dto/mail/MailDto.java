package com.project.stussy.web.dto.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//도메인까지 아나넘어 가서 엔티티만 만듦
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailDto {
	private String userName;
	private String address;
	private String title;
	private String message;

}
