package com.project.stussy.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	//가입 회원 저장 
	public int save(User user);
	
	//user_email 을 통해서 회원정보를 찾아내겠다.
	public User findByUderEmail(String user_email);
}
