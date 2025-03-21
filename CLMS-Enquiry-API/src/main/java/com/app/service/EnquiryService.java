package com.app.service;

import com.app.entity.LoanEnquiry;

public interface EnquiryService {

	public void deleteEnquiryField(Integer id);
	
	String saveEnquiry(LoanEnquiry enquiry);

}
