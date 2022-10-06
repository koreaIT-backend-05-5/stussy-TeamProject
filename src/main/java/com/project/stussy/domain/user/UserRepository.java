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
	
	//관리자페이지 회원정보 삭제
	public int remove(int user_code) throws Exception; 
	
}
