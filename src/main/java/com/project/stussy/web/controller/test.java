package com.project.stussy.web.controller;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping; @Controller 
public class test { 
	@GetMapping("/iamport")
	public String iamport(){ 
		return "index"; } }
