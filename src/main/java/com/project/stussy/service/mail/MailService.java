package com.project.stussy.service.mail;

import com.project.stussy.domain.mall.Mail;

public interface MailService {
	void sendMail(Mail mail) throws Exception;
}
