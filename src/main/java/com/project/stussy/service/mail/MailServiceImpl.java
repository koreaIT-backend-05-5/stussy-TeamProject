package com.project.stussy.service.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
//import org.apache.commons.l

import com.project.stussy.config.mailHandler.MailHandler;
import com.project.stussy.web.dto.mail.MailDto;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService{
	
    private final JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "zxcxv10@naver.com";
    
    public void mailSend(MailDto mailDto) {
        try {
        	System.out.println(mailSender);
            MailHandler mailHandler = new MailHandler(mailSender);
            
           // 받는 사람
           mailHandler.setTo(mailDto.getAddress());
           // 보내는 사람
           mailHandler.setFrom(MailServiceImpl.FROM_ADDRESS);
           // 제목
           mailHandler.setSubject("비밀번호 재설정");
           // HTML Layout
           String htmlContent = "<p>" + mailDto.getUserName() + "고객님의 스투시 계정 비밀번호 변경을 요청했습니다.<br> \r\n"
           		+ "고객님 본인이 요청한 경우 아래 버튼을 눌러 비밀번호를 새로 설정할 수 있습니다.<br> \r\n "
           		+ "<button type=button><a href='http://localhost:8005/auth/resetPassword/" + mailDto.getAddress() + "'> <br> RESET PASSWORD</a></button> <br> \r\n"
           		+ "비밀번호를 재설정 후 로그인하는 것이 안전합니다.<br>\r\n"
           		+ "본인이 요칭하신 게 아니라면 SUPPORT@STUSSY.CO.KR 로 문의 부탁드립니다.<br>\r\n"
           		+ "의심스러운 비밀번호 재설정 요청에 관해 자세히 알아보세요.</p>";
           mailHandler.setText(htmlContent, true);
      
           mailHandler.send();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

