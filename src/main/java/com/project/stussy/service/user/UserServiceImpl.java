package com.project.stussy.service.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.stussy.domain.user.UserRepository;
import com.project.stussy.web.dto.user.GetUserListDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Override
	public List<GetUserListDto> getUserList(int page, String searchFlag, String searchValue) throws Exception {
		int index = (page - 1) * 10;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("index", index); 
		map.put("search_flag", searchFlag);
		map.put("search_value", searchValue == null ? "" : searchValue);
		
		List<GetUserListDto> userList = new ArrayList<GetUserListDto>();
		
		userRepository.getUserList(map).forEach(user -> {
			userList.add(user.toUserListDto());
		});
		return userList;
	}

	//관리자페이지 회원정보 삭제 
	@Override
	public boolean removeUser(int userCode) throws Exception {
		return userRepository.remove(userCode) > 0;
	}

}
