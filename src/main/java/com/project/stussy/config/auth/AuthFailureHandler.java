package com.project.stussy.config.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


public class AuthFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException exception) throws IOException, ServletException {
		System.out.println("메세지: " + exception.getMessage());
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print("<html><head></head><body>"
				+ "<script>alert(\"이메일 또는 비밀번호를 확인하세요.\");history.back();</script>"
				+ "</body></html>");
	}
		
	

}




