package com.project.stussy.service.mail;

import com.project.stussy.domain.mail.Mail;

public interface MailService {
	//문의사항 메일 보내기
	void sendMail(Mail mail) throws Exception;
	
	//비밀번호 찾기 임시비밀번호 보내기
//	String sendRandomPssword(String email) throws Exception;
	String getRamdomPassword(String email) throws Exception;
}




