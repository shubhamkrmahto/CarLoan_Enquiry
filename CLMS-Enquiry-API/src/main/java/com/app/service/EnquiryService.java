package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.app.entity.LoanEnquiry;

public interface EnquiryService {

	public void deleteEnquiryField(Integer id);
	
	String saveEnquiry(LoanEnquiry enquiry);
	
	public String updateFullName(Integer id, String cname);
	
	public String updateDateOfBirth(Integer id, LocalDate dob);

	public String updateGender(Integer id, String gender);
	
	public String updateEmail(Integer id, String email);
	
	public String updateContact(Integer id, Long contact);

	public String updateAlternate(Integer id, Long alternate);

	public String updateAadharNo(Integer id, Long aadharNo);
	
	public String updatePanNo(Integer id, Long panNo);
	
	public Optional<LoanEnquiry> findByEnquiryId(int enquiryId , LoanEnquiry loanEnquiry);

	public List<LoanEnquiry> getAllDataEnquiryOfCustomer();

	public LoanEnquiry getSingleEnquiry(Integer enquiryId);
}
