package com.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.LoanEnquiry;
import com.app.repository.EnquiryRepository;
import com.app.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	@Autowired
	private EnquiryRepository enquiryRepository;

	@Override
	public LoanEnquiry getSingleEnquiry(Integer id) {
		Optional<LoanEnquiry> byId = enquiryRepository.findById(id);	
		return byId.get();
	}

	@Override
	public List<LoanEnquiry> getAllDataEnquiryOfCustomer() {
		
		return	enquiryRepository.findAll();
	
	}
	
	
}
