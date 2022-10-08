package com.project.stussy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.project.stussy.domain.user.User;

public class CartInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(); 
		
		User user = (User)session.getAttribute("user");
		
		if(user == null) {
			response.sendRedirect("/stussy/main");
			return false; 
		}else {
			return true; 
		}
	}

	
}
