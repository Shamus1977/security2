package com.mosby.security2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

	@GetMapping("/contact")
	public String saveContactInquiryDetails() {
		return "Inquiry details saved to DB";
	}
	
	@PostMapping("/contact")
	public String contactInquiryDetails() {
		return "Inquiry details saved to DB";
	}
}
