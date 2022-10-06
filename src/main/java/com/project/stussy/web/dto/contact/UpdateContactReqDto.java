package com.project.stussy.web.dto.contact;

import com.project.stussy.domain.contact.Contact;

import lombok.Data;

@Data
public class UpdateContactReqDto {
	private int contactCode;
	private String contactTitle;
	private String contactContent;
	
		public Contact toEntity() {
			
			return Contact.builder()
						.contact_code(contactCode)
						.contact_title(contactTitle)
						.contact_content(contactContent)
						.build();
						
		}
}
