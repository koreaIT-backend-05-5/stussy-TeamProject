package com.project.stussy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CorsFilter;

import com.project.stussy.config.authHandler.AuthFailureHandler;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		
			.antMatchers("/manager/**")
			.access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
			
			.antMatchers("/account/main")
			.access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
				
			.anyRequest()					
			.permitAll()
			
			.and()
			
			.formLogin()
			.usernameParameter("useremail")
			.loginPage("/auth/signin")
			.loginProcessingUrl("/auth/signin")
			.failureHandler(new AuthFailureHandler())
			.defaultSuccessUrl("/main")
			
			.and()
			
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //로그아웃을 호출할 경우 해당 경로 
			.logoutSuccessUrl("/auth/signin") //로그아웃이 성공했을 경우 해당 경로 
			.invalidateHttpSession(true); //로그아웃시 인증정보를 지우고 세션을 무효화 시키는 설정

	}
}
