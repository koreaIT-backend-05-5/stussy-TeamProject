package com.project.stussy.service.auth;


import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.stussy.domain.user.User;
import com.project.stussy.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JavaMailSender mailSender;
    private final UserRepository userRepository;

    @Value("${spring.mail.username}")
    private String sender;


    public String sendForgotPassword(String useremail) throws NotFoundException{
    	User userEntity = null;
    	try {
			userEntity = userRepository.findUserByUseremail(useremail);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(useremail);
		}
		
		if(userEntity == null) {
			throw new UsernameNotFoundException(useremail + "이메일은 사용할 수 없습니다.");
		}else{
            String tempPassword = getTempPassword();
			
            //메세지를 생성하고 보낼 메일 설정 저장
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(useremail);
            message.setFrom(sender);
            message.setSubject(userEntity.getUser_name()+" : New Temporary Password is here!");
            message.setText("Hello" + userEntity.getUser_email() + "! We send your temporary password here. \nBut this is not secured so please change password once you sign into our site. \nPassword : " + tempPassword);
            mailSender.send(message);
            return "Temporary password sent to your email.";
        }
    }
		
		

      

	//임시 비밀번호 발급
    public String getTempPassword(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }
}
