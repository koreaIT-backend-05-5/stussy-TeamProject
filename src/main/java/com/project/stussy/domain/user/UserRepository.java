package com.project.stussy.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	//회원가입
	public int save(User user) throws Exception;
	//로그인
	public User findUserByUseremail(String useremail) throws Exception;
	
}
