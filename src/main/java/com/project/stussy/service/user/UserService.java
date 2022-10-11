package com.project.stussy.service.user;

import java.util.List;

import com.project.stussy.web.dto.user.GetUserListDto;

public interface UserService {
	//관리자페이지 - user
	public List<GetUserListDto> getUserList(int page, String searchFlag, String searchValue) throws Exception; 
	
	//관리자페이지 회원정보 삭제
	public boolean removeUser(int userCode) throws Exception; 
}
