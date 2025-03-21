package com.app.service;

import java.util.Optional;

import com.app.entity.LoanEnquiry;

public interface EnquiryService {

	public Optional<LoanEnquiry> findByEnquiryId(int enquiryId, LoanEnquiry loanEnquiry);
	
	
}
