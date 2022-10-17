package com.project.stussy.service.mail;

import com.project.stussy.web.dto.mail.MailDto;

public interface MailService {
	//문의사항 메일 보내기
	void mailSend(MailDto mailDto) throws Exception;
	
}




