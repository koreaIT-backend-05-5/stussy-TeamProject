package com.project.stussy.service.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.stussy.domain.mail.Mail;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService{
	
	private JavaMailSender javaMailSender;
	// 관리자 아이디 
	private static final String FROM_ADDRESS = "izx43@naver.com";
	
	@Override
		public void sendMail(Mail mail) throws Exception {
		
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setTo(mail.getAddress());
			message.setFrom(FROM_ADDRESS);
			message.setSubject(mail.getTitle());
			message.setText(mail.getMessage());
			
			System.out.println(message);
			
			javaMailSender.send(message);
		}
}
