package com.project.stussy.service.mail;

import java.security.SecureRandom;
import java.util.Date;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
//import org.apache.commons.l

import com.project.stussy.domain.mail.Mail;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService{
	
	private JavaMailSender javaMailSender;
	
	// 관리자 아이디 
	private static final String FROM_ADDRESS = "izx43@naver.com";
	
	//문의사항 메일 
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

//	//임시비밀번호
//	@Override
//	public String sendRandomPssword(String email) throws Exception {
//		
//		SimpleMailMessage message = new SimpleMailMessage();
//		System.out.println(email);
//		
//		String randomPassword = RandomStringUtils.randomAlphanumeric(9) + "!"; //임시비밀번호 생성
//		String randomPassword = "tempPassword!"; //임시비밀번호 생성
//		
//		
//		message.setTo(email);
//		message.setFrom("zxcxv10@naver.com");
//		message.setSubject("임시비밀번호");
//		message.setText("임시비밀번호: " + randomPassword);
//		
//		javaMailSender.send(message);
//		
//		return randomPassword;
//	}
	
    public String getRamdomPassword(String email) {
		SimpleMailMessage message = new SimpleMailMessage();
    
        char[] charSet = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '!', '@', '#', '$', '%', '^', '&' };

        StringBuffer sb = new StringBuffer();
        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());

        int idx = 0;
        int len = charSet.length;
        for (int i=0; i<email.length(); i++) {
            // idx = (int) (len * Math.random());
            idx = sr.nextInt(len);    // 강력한 난수를 발생시키기 위해 SecureRandom을 사용한다.
            sb.append(charSet[idx]);
        }
        
        message.setTo(email);
		message.setFrom("zxcxv10@naver.com");
		message.setSubject("임시비밀번호");
		message.setText("임시비밀번호: " + sb.toString());
		
		javaMailSender.send(message);

        return sb.toString();
    }
}
