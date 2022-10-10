package com.project.stussy.domain.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import lombok.Data;

@Mapper
public interface UserRepository {
	//회원가입
	public int save(User user) throws Exception;
	//로그인
	public User findUserByUseremail(String useremail) throws Exception;
	
	//관리자페이지-user
	public List<User> getUserList(Map<String, Object> map) throws Exception; 
	
	//임시비밀번호로 메일 보내기
	public int updatePassword(Map<String, String> map) throws Exception;
	
		
}
