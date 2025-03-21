package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.LoanEnquiry;
import com.app.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	@Autowired
	EnquiryService enquiryService;
	
	@PostMapping("/enquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody LoanEnquiry enquiry){
		
		String msg = enquiryService.saveEnquiry(enquiry);
		System.out.println(enquiry);
		
		return new  ResponseEntity<String>(msg , HttpStatus.OK);
		
		
		
	}

}
