package com.app.serviceimpl;

import java.util.Optional;

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
	private EnquiryRepository enquiryRepository;

	@Autowired
	JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String from;  
	
	
	@Override
	public void deleteEnquiryField(Integer id) { 
		enquiryRepository.deleteById(id);		
	}
	

	@Override
	public String saveEnquiry(LoanEnquiry enquiry) {
		enquiryRepository.save(enquiry);
		
		
		SimpleMailMessage mail= new SimpleMailMessage();
		mail.setFrom(from);
		mail.setTo(enquiry.getCustomerEmailId());
		
		mail.setSubject("Regarding Loan Enquiry");
		mail.setText("Your Loan enquiry request has been Registed.Our Customer executive will reach you out soon. Stay connected ");
		
		mailSender.send(mail);
		return "Enquiry registered";
				
	}


	@Override
	public String updateName(Integer id, String cname) {
		// TODO Auto-generated method stub
		
		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerName(cname);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Name has been updated Successfully.";
	}


	@Override
	public String updateContact(Integer id, Long contact) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerContactNumber(contact);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Contact Number has been updated Successfully.";
	}


	@Override
	public String updateAlternate(Integer id, Long alternate) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerAlternateNumber(alternate);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Alternate Contact has been updated Successfully.";
	}


	@Override
	public String updateEmail(Integer id, String email) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerEmailId(email);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Email has been updated Successfully.";
	}


	@Override
	public String updateAddress(Integer id, String address) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerPermanentAddress(address);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer permanent address has been updated Successfully.";
	}


	@Override
	public String updateCity(Integer id, String city) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerCity(city);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer City has been updated Successfully.";
	}


	@Override
	public String updatePincode(Integer id, Integer pincode) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerPincode(pincode);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Name has been updated Successfully.";
	}

}
