package com.project.stussy.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.stussy.domain.user.User;
import com.project.stussy.domain.user.UserRepository;
import com.project.stussy.web.dto.auth.UseremailCheckReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private final UserRepository userRepository;

	@Override
	public String checkUseremail(UseremailCheckReqDto useremailCheckReqDto) throws Exception{
		
		User user = userRepository.findUserByUseremail(useremailCheckReqDto.getUseremail());
		
		if(user == null) {
			
			return null;
			
		}else {
			return user.getUser_name();
		}
		
	}

	@Override
	public boolean signup() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	//비밀번호변경
	@Override
		public boolean updatePassword(String email, String password) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
			map.put("user_email", email);
			map.put("user_password", new BCryptPasswordEncoder().encode(password));
			return userRepository.updatePassword(map) > 0;
		}

}
