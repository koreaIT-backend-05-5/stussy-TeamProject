package com.project.stussy.domain.contact;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactRepository {
	
	// 문의사항 작성
	public int saveContact(Contact contact) throws Exception;
	
	// 문의사항 상세페이지
	public List<Contact> getContact(Map<String, Object> map) throws Exception;
	
	// 문의사항 갯수 
	public int countIncrement(Map<String, Object> map) throws Exception;
	
	// 문의사항 리스트로 가져오기
	public List<Contact> getContactList(int index) throws Exception;
	public List<Contact> getContactList(Map<String, Object> map) throws Exception;
	
	// 문의사항 수정
	public int updateContactByContactCode(Contact contact) throws Exception;
	
	// 문의사항 삭제
	public int remove(int contactCode) throws Exception;
	
	//======================================문의사항==========================================//
	
	// 관리자 문의사항 답변하기 상세페이지
	public List<Contact> managerGetContact(Map<String, Object> map) throws Exception;
	
}	
