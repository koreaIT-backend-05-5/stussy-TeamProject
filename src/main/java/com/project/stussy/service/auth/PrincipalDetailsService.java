package com.project.stussy.service.auth;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.stussy.domain.user.User;
import com.project.stussy.domain.user.UserRepository;
import com.project.stussy.web.dto.auth.SignupReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
		User userEntity = null;
		
		
		try {
			userEntity = userRepository.findUserByUseremail(useremail);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(useremail);
		}
		
		if(userEntity == null) {
			throw new UsernameNotFoundException(useremail + "이메일은 사용할 수 없습니다.");
		}
		
		return new PrincipalDetails(userEntity);
		
	}
	
	public boolean addUser(SignupReqDto signupReqDto) throws Exception {
		
		return userRepository.save(signupReqDto.toEntity())>0;
	}

}