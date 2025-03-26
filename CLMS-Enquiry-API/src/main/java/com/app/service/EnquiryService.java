package com.app.service;

import java.util.Optional;

import com.app.entity.LoanEnquiry;

public interface EnquiryService {

	public void deleteEnquiryField(Integer id);
	
	String saveEnquiry(LoanEnquiry enquiry);
	
	public String updateName(Integer id, String cname);
	
	public String updateContact(Integer id, Long contact);

	public String updateAlternate(Integer id, Long alternate);
	
	public String updateEmail(Integer id, String email);
	
	public String updateAddress(Integer id, String address);
	
	public String updateCity(Integer id, String city);
	
	public String updatePincode(Integer id, Integer pincode);

	public String findByEnquiryId(int enquiryId , LoanEnquiry loanEnquiry);
}
