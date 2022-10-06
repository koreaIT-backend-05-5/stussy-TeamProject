package com.project.stussy.service.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.stussy.domain.mall.Mail;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailServiceImp implements MailService{
	
	private JavaMailSender javaMailSender;
	private static final String FROM_ADRESS = "zxcxv10@naver.com";

	@Override
	public void sendMail(Mail mail) throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(mail.getAddress());
		message.setFrom(FROM_ADRESS);
		message.setSubject(mail.getTitle());
		message.setText(mail.getMessage());
		
		javaMailSender.send(message);
		
	}
}
