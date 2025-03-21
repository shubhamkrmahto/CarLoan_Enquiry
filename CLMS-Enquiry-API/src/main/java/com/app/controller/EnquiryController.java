package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.LoanEnquiry;
import com.app.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	@Autowired
	EnquiryService enquiryService;
	
	@GetMapping("/getSingleEnquiry/{id}")
	public ResponseEntity<LoanEnquiry> getSingleEnquiry(@PathVariable("id") Integer id)
	{
		    LoanEnquiry loanEnquiry = enquiryService.getSingleEnquiry(id);   
	        return new ResponseEntity<LoanEnquiry>(loanEnquiry,HttpStatus.OK);
	}
	
	@GetMapping("/getAllEnquiry")
	public ResponseEntity<List<LoanEnquiry>> getAllEnquiry()
	{
		   List<LoanEnquiry> loanEnquiry = enquiryService.getAllDataEnquiryOfCustomer(); 
		    
	        return new ResponseEntity<List<LoanEnquiry>>(loanEnquiry,HttpStatus.OK);
	}


}
