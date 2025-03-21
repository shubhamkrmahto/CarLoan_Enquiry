package com.app.service;

import java.util.List;

import com.app.entity.LoanEnquiry;

public interface EnquiryService {

	public LoanEnquiry getSingleEnquiry(Integer id);
  
     public List<LoanEnquiry> getAllDataEnquiryOfCustomer();

}
