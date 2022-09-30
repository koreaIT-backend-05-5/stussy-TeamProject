package com.project.stussy.web.dto.contact;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetContactResponseDto {
	private int contactCode;
	private String contactTitle;
	private String userEmail;
	private String createDate;
	private int contactCount;
	private String contactContent;
}
