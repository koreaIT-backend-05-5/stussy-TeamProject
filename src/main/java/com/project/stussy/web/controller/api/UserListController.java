package com.project.stussy.web.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.stussy.service.user.UserService;
import com.project.stussy.web.dto.CMRespDto;
import com.project.stussy.web.dto.user.GetUserListDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/manager")
@RequiredArgsConstructor
@Slf4j
public class UserListController {
	
	private final UserService userService; 
	
	//관리자페이지 - user리스트 조회
	@GetMapping("/manager-user/{page}")
	public ResponseEntity<?> getUserList(@PathVariable int page, @RequestParam String searchFlag, @RequestParam String searchValue) {
		List<GetUserListDto> userListDto = null; 
		
		try {
			userListDto = userService.getUserList(page, searchFlag, searchValue);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1,"database error",userListDto));
		}
		return ResponseEntity.ok(new CMRespDto<>(1,"lookup successful", userListDto));
	}
	
	//관리자페이지 회원정보 삭제
	@DeleteMapping("/user/{userCode}") 
	public ResponseEntity<?> removeUser(@PathVariable int userCode) {
		boolean status = false; 
		try {
			status = userService.removeUser(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failed", status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", status));
	}

}
