package com.project.stussy.domain.contact;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.project.stussy.web.dto.contact.GetContactListResponseDto;
import com.project.stussy.web.dto.contact.UpdateContactReqDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {
	private int contact_code;
	private String contact_title;
	private String user_email;
	private String contact_content;
	private int contact_count;
	private LocalDateTime create_date;
	
	private int total_contact_count;
	
	public GetContactListResponseDto toListDto() {
		return GetContactListResponseDto.builder()
						.contactCode(contact_code)
						.contactTitle(contact_title)
						.userEmail(user_email)
						.createDate(create_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
						.contactCount(contact_count)
						.totalContactCount(total_contact_count)
						.build();
						
					}

}
