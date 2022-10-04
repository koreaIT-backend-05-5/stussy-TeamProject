package com.project.stussy.service.contact;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.stussy.domain.contact.Contact;
import com.project.stussy.domain.contact.ContactRepository;
import com.project.stussy.web.dto.contact.AddContactReqDto;
import com.project.stussy.web.dto.contact.GetContactListResponseDto;
import com.project.stussy.web.dto.contact.GetContactResponseDto;
import com.project.stussy.web.dto.contact.UpdateContactReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
	
	private final ContactRepository contactRepository;
	
	
	// 문의사항 홈, 검색
	@Override
	public List<GetContactListResponseDto> getContactList(int page, String searchFlag, String searchValue) throws Exception {
		int index = (page - 1) * 10;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("index", index);
		map.put("search_flag", searchFlag);
		map.put("search_value", searchValue == null ? "" : searchValue);
		
		List<GetContactListResponseDto> list = new ArrayList<GetContactListResponseDto>();
		 
		contactRepository.getContactList(map).forEach(contact -> {
			list.add(contact.toListDto());
		});
		
		return list;
	}
	
	
	// 문의사항 작성
	@Override
	public int addContact(AddContactReqDto addContactReqDto) throws Exception {
		
		Contact contact = null;
		
		String contactTitle = addContactReqDto.getContactTitle();
		
		contact = Contact.builder()
				.contact_title(addContactReqDto.getContactTitle())
				.user_email(addContactReqDto.getUserEmail())
				.contact_content(addContactReqDto.getContactContent())
				.build();
		
		
		contactRepository.saveContact(contact);
		
		
		return contact.getContact_code();
	}
	
	// 문의사항 상세페이지
	@Override
	public GetContactResponseDto getContact(String flag, int contactCode) throws Exception {
		GetContactResponseDto getContactResponseDto = null;
		
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("flag", flag);
		reqMap.put("contact_code", contactCode);
		
		contactRepository.countIncrement(reqMap);
		
		List<Contact> contacts = contactRepository.getContact(reqMap);
		
		if(!contacts.isEmpty()) {
			Contact firstContact = contacts.get(0);
			
			getContactResponseDto = GetContactResponseDto.builder()
									.contactCode(firstContact.getContact_code())
									.contactTitle(firstContact.getContact_title())
									.userEmail(firstContact.getUser_email())
									.createDate(firstContact.getCreate_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
									.contactCount(firstContact.getContact_count())
									.contactContent(firstContact.getContact_content())
									.build();
		}
		
		return getContactResponseDto;
	}
	
	
	// 문의사항 수정
	@Override
	public boolean updateContact(UpdateContactReqDto updateContactReqDto) throws Exception {
		return contactRepository.updateContactByContactCode(updateContactReqDto.toEntity()) > 0;

	}
	
	// 문의사항 삭제
	@Override
	public boolean removeContact(int contactCode) throws Exception {
		return contactRepository.remove(contactCode) > 0;
	}
}
