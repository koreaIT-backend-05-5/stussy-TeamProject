package com.project.stussy.web.controller.api;


import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.project.stussy.service.contact.ContactService;
import com.project.stussy.web.dto.CMRespDto;
import com.project.stussy.web.dto.contact.AddContactReqDto;
import com.project.stussy.web.dto.contact.GetContactListResponseDto;
import com.project.stussy.web.dto.contact.GetContactResponseDto;
import com.project.stussy.web.dto.contact.UpdateContactReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/contact")
@Slf4j
@RequiredArgsConstructor
public class ContactRestController {
	
	private final ContactService contactService;
	
	// 문의사항 작성
	@PostMapping("")
	public ResponseEntity<?> addContact(@RequestBody AddContactReqDto addContactReqDto) {
		log.info(">>>>>> {}", addContactReqDto);
		
		int contactCode = 0;
		
		try {
			contactCode = contactService.addContact(addContactReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Failed to write", contactCode));
		}
		
		return ResponseEntity.ok(new CMRespDto<>(1, "completing creation", contactCode));
	}
	
//============================관리자 문의사항 페이지============================//
	
	// 문의사항 리스트 페이지 10개씩 나눠서 가져오기, 문의사항 검색
	@GetMapping("/manager/list/{page}")
	public ResponseEntity<?> getContactList(@PathVariable int page, @RequestParam String searchFlag, @RequestParam String searchValue) {
		
		List<GetContactListResponseDto> listDto = null;
		
		log.info("{}, {}", searchFlag, searchValue);
		
		
		try {
			listDto = contactService.getContactList(page, searchFlag, searchValue);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database to error", listDto));
		}
		return ResponseEntity.ok(new CMRespDto<>(1, "lookup successful", listDto));
	}
	
	
	// 문의사항 작성후 페이지
	@GetMapping("/manager/{contactCode}")
	public ResponseEntity<?> getContact(@PathVariable int contactCode) {
		GetContactResponseDto getContactResponseDto = null;
		
		try {
			getContactResponseDto = contactService.getContact(null, contactCode);
			if(getContactResponseDto == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", getContactResponseDto));
		
	}
	
	// 문의사항 작성후 페이지 pre,next 버튼 / 조회수
	@GetMapping("/manager/{flag}/{contactCode}")
	public ResponseEntity<?> getContact(@PathVariable String flag, @PathVariable int contactCode) {
		GetContactResponseDto getContactResponseDto = null;
		
		if(flag.equals("pre") || flag.equals("next")) {
			try {
				getContactResponseDto = contactService.getContact(flag, contactCode);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "database error", null));
			}
			
		}else {
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
		}
		
		return  ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", getContactResponseDto));
		
	}	
	
	
	// 문의사항 수정
	@PutMapping("/manager/modify/{contactCode}")
	public ResponseEntity<?> updateContact(@PathVariable int contactCode, UpdateContactReqDto updateContactReqDto) {
		boolean status = false;
		
		try {
			updateContactReqDto.setContactCode(contactCode);
			status = contactService.updateContact(updateContactReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failed", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", status));
	}
	
	@DeleteMapping("/manager/view/{contactCode}")
	public ResponseEntity<?> removeContact(@PathVariable int contactCode) {
		boolean status = false;
		
		try {
			status = contactService.removeContact(contactCode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failed", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", status));
	}
	
}
