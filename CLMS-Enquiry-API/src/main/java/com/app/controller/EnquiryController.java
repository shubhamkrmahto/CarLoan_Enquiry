package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	@Autowired
	private EnquiryService enquiryService;
	
	@DeleteMapping("/deleteEnquiryField/{id}")
	public ResponseEntity<String> deleteEnquiryField(@PathVariable("id") Integer id)
	{
		enquiryService.deleteEnquiryField(id);
		return new ResponseEntity<String>("Delete Your Enquiry Field Successfully...!",HttpStatus.OK);
	}

}
 