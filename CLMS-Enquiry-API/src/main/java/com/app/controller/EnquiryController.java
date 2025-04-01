package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@Autowired
	private EnquiryService enquiryService;
	
	@DeleteMapping("/deleteEnquiryField/{id}")
	public ResponseEntity<String> deleteEnquiryField(@PathVariable("id") Integer id)
	{
		
		enquiryService.deleteEnquiryField(id);
		return new ResponseEntity<String>("Delete Your Enquiry Field Successfully...!",HttpStatus.OK);

	}
		
	
	@PostMapping("/enquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody LoanEnquiry enquiry){
		
		
		String msg = enquiryService.saveEnquiry(enquiry);
		System.out.println(enquiry);
		
		return new  ResponseEntity<String>(msg , HttpStatus.OK);			
	}
	
	@PatchMapping("/updateCustomerName/{id}/{cname}")
	public ResponseEntity<String> updateCustomerName(@PathVariable("id") Integer id, @PathVariable("cname") String cname)
	{
		String msg = enquiryService.updateName(id, cname);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

			
	}
	
	@PutMapping("/changeEnquiryData/{enquiryId}")
	public ResponseEntity<Optional<LoanEnquiry>> editData(@PathVariable("enquiryId") int enquiryId, 
			                                    @RequestBody LoanEnquiry loanEnquiry)
	{
		

		Optional<LoanEnquiry> loan=enquiryService.findByEnquiryId(enquiryId,loanEnquiry);
		return new ResponseEntity<Optional<LoanEnquiry>>(loan, HttpStatus.ACCEPTED);

		
	}
	
	@PatchMapping("/updateContact/{id}/{contact}")
	public ResponseEntity<String> updateCustomerContact(@PathVariable("id") Integer id, @PathVariable("contact") long con)
	{
		
		String msg = enquiryService.updateContact(id, con);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/updateAlternateContact/{id}/{alter}")
	public ResponseEntity<String> updateCustomerAlternate(@PathVariable("id") Integer id, @PathVariable("alter") long alter)
	{
		
		String msg = enquiryService.updateAlternate(id, alter);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/updateEmail/{id}/{email}")
	public ResponseEntity<String> updateCustomerEmail(@PathVariable("id") Integer id, @PathVariable("email") String email)
	{
		
		String msg = enquiryService.updateEmail(id, email);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/updateAddress/{id}/{address}")
	public ResponseEntity<String> updateCustomerAddress(@PathVariable("id") Integer id, @PathVariable("address") String address)
	{
		
		String msg = enquiryService.updateAddress(id, address);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/updateCity/{id}/{city}")
	public ResponseEntity<String> updateCustomerCity(@PathVariable("id") Integer id, @PathVariable("city") String city)
	{
		
		String msg = enquiryService.updateCity(id, city);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/updatePincode/{id}/{pincode}")
	public ResponseEntity<String> updateCustomerPincode(@PathVariable("id") Integer id, @PathVariable("pincode") Integer pincode)
	{
		
		String msg = enquiryService.updatePincode(id, pincode);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}
	@GetMapping("/getSingleEnquiry/{enquiryId}")
	public ResponseEntity<LoanEnquiry> getSingleEnquiry(@PathVariable("enquiryId") Integer enquiryId)
	{
		    LoanEnquiry loanEnquiry = enquiryService.getSingleEnquiry(enquiryId);   
	        return new ResponseEntity<LoanEnquiry>(loanEnquiry,HttpStatus.OK);
	}
	
	@GetMapping("/getAllEnquiry")
	public ResponseEntity<List<LoanEnquiry>> getAllEnquiry()
	{
		   List<LoanEnquiry> loanEnquiry = enquiryService.getAllDataEnquiryOfCustomer(); 
		    
	        return new ResponseEntity<List<LoanEnquiry>>(loanEnquiry,HttpStatus.OK);
	}


	

}
 