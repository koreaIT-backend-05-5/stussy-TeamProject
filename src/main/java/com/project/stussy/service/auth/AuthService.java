package com.project.stussy.service.auth;

import com.project.stussy.web.dto.auth.UseremailCheckReqDto;

public interface AuthService {
	public boolean checkUseremail(UseremailCheckReqDto useremailCheckReqDto) throws Exception;
	public boolean signup()throws Exception;
	
	//임시 비밀번호 보내기
	public boolean updatePassword(String email, String password) throws Exception;

}
