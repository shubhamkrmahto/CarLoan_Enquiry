package com.app.controller;

import java.net.http.HttpClient;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/changeEnquiryData/{enquiryId}")
	public ResponseEntity<Optional<LoanEnquiry>> updateData(@PathVariable("enquiryId") int enquiryId,
			                                       @RequestBody LoanEnquiry loanEnquiry
			                                       )
	{
		Optional<LoanEnquiry> loan=enquiryService.findByEnquiryId(enquiryId, loanEnquiry);
		
		//LoanEnquiry loanData=loan.get();
//		loanData.setCustomerName(loanEnquiry.getCustomerName());
//		loanData.set
		return new ResponseEntity<Optional<LoanEnquiry>>(loan, HttpStatus.ACCEPTED);
	}
}
