package com.app.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.LoanEnquiry;
import com.app.repository.EnquiryRepository;
import com.app.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	EnquiryRepository enquiryRepo;
	
	@Override
	public Optional<LoanEnquiry> findByEnquiryId(int enquiryId, LoanEnquiry loanEnquiry) {
		Optional<LoanEnquiry> enquiry=enquiryRepo.findById(enquiryId);
		LoanEnquiry loanData = enquiry.get();
		
		loanData.setCustomerName(loanEnquiry.getCustomerName());
		loanData.setCustomerContactNumber(loanEnquiry.getCustomerContactNumber());
		loanData.setCustomerAlternateNumber(loanEnquiry.getCustomerAlternateNumber());
		loanData.setCustomerEmailId(loanEnquiry.getCustomerEmailId());
		loanData.setCustomerPermanentAddress(loanEnquiry.getCustomerPermanentAddress());
		loanData.setCustomerCity(loanEnquiry.getCustomerCity());
		loanData.setCustomerPincode(loanEnquiry.getCustomerPincode());
		loanData.setEnquiryDateTime(LocalDate.now());
		
		enquiryRepo.save(loanData);
		
		
		
		return Optional.of(loanData);
	}

}
