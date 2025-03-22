package com.app.service;

import java.util.Optional;

import com.app.entity.LoanEnquiry;

public interface EnquiryService {

	String saveEnquiry(LoanEnquiry enquiry);

	public Optional<LoanEnquiry> findByEnquiryId(int enquiryId , LoanEnquiry loanEnquiry);
}
