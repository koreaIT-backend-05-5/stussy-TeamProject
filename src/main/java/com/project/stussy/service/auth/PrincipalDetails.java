package com.project.stussy.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.stussy.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}

	//권한 부여
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
		user.getUserRoles().forEach(role -> {
			grantedAuthorities.add(() -> role);
		});
		
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return user.getUser_password();
	}

	@Override
	public String getUsername() {
		return user.getUser_name();
	}
	
	
	//계정 만료 여부
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정 잠김 여부
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//비밀번호 만료 여부
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//사용자 활성화 여부
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
