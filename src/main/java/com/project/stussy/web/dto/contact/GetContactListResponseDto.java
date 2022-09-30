package com.project.stussy.web.dto.contact;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetContactListResponseDto {
	private int contactCode;
	private String contactTitle;
	private String userEmail;
	private String createDate;
	private int contactCount;
	private int totalContactCount;
}
