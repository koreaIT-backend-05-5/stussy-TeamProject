package com.project.stussy.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.stussy.domain.user.UserRepository;
import com.project.stussy.web.dto.auth.UseremailCheckReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private final UserRepository userRepository;

	@Override
	public boolean checkUseremail(UseremailCheckReqDto useremailCheckReqDto) throws Exception{
		
		return userRepository.findUserByUseremail(useremailCheckReqDto.getUseremail()) == null;
	}

	@Override
	public boolean signup() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
		public boolean updatePassword(String email, String password) throws Exception {
		System.out.println(password);
		Map<String, String> map = new HashMap<String, String>();
			map.put("user_email", email);
			map.put("user_password", new BCryptPasswordEncoder().encode(password));
			return userRepository.updatePassword(map) > 0;
		}

}
