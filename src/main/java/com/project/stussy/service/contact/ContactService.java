package com.project.stussy.service.contact;

import java.util.List;

import com.project.stussy.web.dto.contact.AddContactReqDto;
import com.project.stussy.web.dto.contact.GetContactListResponseDto;
import com.project.stussy.web.dto.contact.GetContactResponseDto;
import com.project.stussy.web.dto.contact.UpdateContactReqDto;

public interface ContactService {
	
	// 문의사항 페이지, 검색
	public List<GetContactListResponseDto> getContactList(int page, String searchFlag, String searchValue) throws Exception;
	
	// 문의사항 작성
	public int addContact(AddContactReqDto addContactReqDto) throws Exception;
	
	// 문의사항 상세페이지
	public GetContactResponseDto getContact(String flag, int contactCode) throws Exception;
	
	// 문의사항 수정
	public boolean updateContact(UpdateContactReqDto updateContactReqDto) throws Exception;
	
	// 문의사항 게시글 삭제
	public boolean removeContact(int contactCode) throws Exception;

}
