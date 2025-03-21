package com.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.entity.LoanEnquiry;
import com.app.repository.EnquiryRepository;
import com.app.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	@Autowired
	EnquiryRepository repo;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String from;  
	

	@Override
	public String saveEnquiry(LoanEnquiry enquiry) {
		repo.save(enquiry);
		
		
		SimpleMailMessage mail= new SimpleMailMessage();
		mail.setFrom(from);
		mail.setTo(enquiry.getCustomerEmailId());
		
		mail.setSubject("Regarding Loan Enquiry");
		mail.setText("Your Loan enquiry request has been Registed.Our Customer executive will reach you out soon. Stay connected ");
		
		mailSender.send(mail);
		return "Enquiry registered";
		
		
	}

}
