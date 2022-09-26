package com.project.stussy.service.auth;

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

}
