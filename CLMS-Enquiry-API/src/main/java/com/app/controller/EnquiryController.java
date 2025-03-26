package com.app.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.LoanEnquiry;
import com.app.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	private static final Logger log= LoggerFactory.getLogger(EnquiryController.class); 
	
	@Autowired
	private EnquiryService enquiryService;
	
	@DeleteMapping("/deleteEnquiryField/{id}")
	public ResponseEntity<String> deleteEnquiryField(@PathVariable("id") Integer id)
	{
		log.info("Enquiry DELETE method called...!");
		enquiryService.deleteEnquiryField(id);
		return new ResponseEntity<String>("Delete Your Enquiry Field Successfully...!",HttpStatus.OK);

	}
		
	
	@PostMapping("/enquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody LoanEnquiry enquiry){
		
		log.info("Enquiry Controller post mapping called...!");
		
		String msg = enquiryService.saveEnquiry(enquiry);
		//System.out.println(enquiry);
		
		
		return new  ResponseEntity<String>(msg , HttpStatus.OK);			
	}
	
	@PatchMapping("/updateCustomerName/{id}/{cname}")
	public ResponseEntity<String> updateCustomerName(@PathVariable("id") Integer id, @PathVariable("cname") String cname)
	{
		log.info("customer name patch method mapping called...!");
		String msg = enquiryService.updateName(id, cname);
		
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);

			
	}
	
	@PutMapping("/changeEnquiryData/{enquiryId}")
	public ResponseEntity<String> editData(@PathVariable("enquiryId") int enquiryId, 
			                                    @RequestBody LoanEnquiry loanEnquiry)
	{
		log.info("put mapping called");

		String msg=enquiryService.findByEnquiryId(enquiryId,loanEnquiry);
		
		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);

		
	}
	
	@PatchMapping("/updateContact/{id}/{contact}")
	public ResponseEntity<String> updateCustomerContact(@PathVariable("id") Integer id, @PathVariable("contact") long con)
	{
		log.info("customer contact PATCH method mapping called...!");
		
		String msg = enquiryService.updateContact(id, con);
		
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/updateAlternateContact/{id}/{alter}")
	public ResponseEntity<String> updateCustomerAlternate(@PathVariable("id") Integer id, @PathVariable("alter") long alter)
	{
		log.info(" CustomerAlternateContact PATCH method mapping called...!");
		
		String msg = enquiryService.updateAlternate(id, alter);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/updateEmail/{id}/{email}")
	public ResponseEntity<String> updateCustomerEmail(@PathVariable("id") Integer id, @PathVariable("email") String email)
	{
		log.info(" Customer Email PATCH method mapping called...!");
		
		String msg = enquiryService.updateEmail(id, email);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/updateAddress/{id}/{address}")
	public ResponseEntity<String> updateCustomerAddress(@PathVariable("id") Integer id, @PathVariable("address") String address)
	{
		log.info(" Constomer Address PATCH method mapping called...!");
		
		String msg = enquiryService.updateAddress(id, address);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/updateCity/{id}/{city}")
	public ResponseEntity<String> updateCustomerCity(@PathVariable("id") Integer id, @PathVariable("city") String city)
	{
		log.info(" Comstomer City PATCH method mapping called...!");
		
		String msg = enquiryService.updateCity(id, city);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/updatePincode/{id}/{pincode}")
	public ResponseEntity<String> updateCustomerPincode(@PathVariable("id") Integer id, @PathVariable("pincode") Integer pincode)
	{
		log.info(" Customer Pincode PATCH method mapping called...!");
		
		String msg = enquiryService.updatePincode(id, pincode);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

}
 