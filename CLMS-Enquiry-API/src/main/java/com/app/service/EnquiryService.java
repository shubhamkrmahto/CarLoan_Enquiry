package com.app.service;

import java.util.List;
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

	public Optional<LoanEnquiry> findByEnquiryId(int enquiryId , LoanEnquiry loanEnquiry);

	public List<LoanEnquiry> getAllDataEnquiryOfCustomer();

	public LoanEnquiry getSingleEnquiry(Integer enquiryId);
}
