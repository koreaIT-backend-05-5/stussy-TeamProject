package com.project.stussy.web.dto.contact;

import lombok.Data;

@Data
public class AddContactReqDto {
	private String contactName;
	private int userCode;
	private String userEmail;
	private int contactOrderNum;
	private String contactTitle;
	private String contactContent;
}
