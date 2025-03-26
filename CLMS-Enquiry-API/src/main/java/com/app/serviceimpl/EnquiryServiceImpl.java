package com.app.serviceimpl;


import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.controller.EnquiryController;
import com.app.entity.LoanEnquiry;
import com.app.repository.EnquiryRepository;
import com.app.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{


	private static final Logger log= LoggerFactory.getLogger(EnquiryServiceImpl.class);

	@Autowired
	private EnquiryRepository enquiryRepository;

	@Autowired
	JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String from;  
	
	
	@Override
	public void deleteEnquiryField(Integer id) { 
		
	
		enquiryRepository.deleteById(id);	
		
		log.info("Enquiry has been Deleted for Enquiry id : " + id);
	}
	

	@Override
	public String saveEnquiry(LoanEnquiry enquiry) {
		
		enquiryRepository.save(enquiry);
		
		log.info("Enquiry has been saved successfully and Enquiry id is : " + enquiry.getEnquiryId());
		SimpleMailMessage mail= new SimpleMailMessage();
		mail.setFrom(from);
		mail.setTo(enquiry.getCustomerEmailId());
		
		mail.setSubject("Regarding Loan Enquiry");
		mail.setText("Your Loan enquiry request has been Registed.Our Customer executive will reach you out soon. Stay connected ");
		
		mailSender.send(mail);
		
		log.info("Mail has been sent to registered Email id : " + enquiry.getCustomerEmailId());
		return "Enquiry registered";
				
	}


	@Override
	public String updateName(Integer id, String cname) {
		// TODO Auto-generated method stub
		
		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerName(cname);
		
		enquiryRepository.save(loanEnquiry);


		log.info("Enquiry Name has been updated successfully , for this id = " + id);
		return "Customer Name has been updated Successfully.";
	}


	@Override
	public String updateContact(Integer id, Long contact) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerContactNumber(contact);
		
		
		enquiryRepository.save(loanEnquiry);
		
		log.info("Enquiry Contact has been updated successfully , for this id = " + id);
		
		return "Customer Contact Number has been updated Successfully.";
	}


	@Override
	public String updateAlternate(Integer id, Long alternate) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerAlternateNumber(alternate);
		
		enquiryRepository.save(loanEnquiry);
		
		log.info("Enquiry AlterNate contact number has been updated successfully , for this id = " + id);
		
		return "Customer Alternate Contact has been updated Successfully.";
	}


	@Override
	public String updateEmail(Integer id, String email) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerEmailId(email);
		
		enquiryRepository.save(loanEnquiry);
		
		log.info("Enquiry Email has been updated successfully , for this id = " + id);
		
		return "Customer Email has been updated Successfully.";
	}


	@Override
	public String updateAddress(Integer id, String address) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerPermanentAddress(address);
		
		enquiryRepository.save(loanEnquiry);
		
		log.info("Enquiry Address has been updated successfully , for this id = " + id);
		
		return "Customer permanent address has been updated Successfully.";
	}


	@Override
	public String updateCity(Integer id, String city) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerCity(city);
		
		enquiryRepository.save(loanEnquiry);
		
		log.info("Enquiry City has been updated successfully , for this id = " + id);
		
		return "Customer City has been updated Successfully.";
	}


	@Override
	public String updatePincode(Integer id, Integer pincode) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setCustomerPincode(pincode);
		
		enquiryRepository.save(loanEnquiry);
		
		log.info("Enquiry pincode has been updated successfully , for this id = " + id);
		
		return "Customer Name has been updated Successfully.";
	}


	@Override
	public String findByEnquiryId(int enquiryId, LoanEnquiry loanEnquiry) {
		
		Optional<LoanEnquiry> loan = enquiryRepository.findById(enquiryId);
		
		LoanEnquiry loanData = loan.get();
		
		if(loan.isPresent())
		{
			
			loanData.setCustomerName(loanEnquiry.getCustomerName());
			loanData.setCustomerContactNumber(loanEnquiry.getCustomerContactNumber());
			loanData.setCustomerAlternateNumber(loanEnquiry.getCustomerAlternateNumber());
			loanData.setCustomerEmailId(loanEnquiry.getCustomerEmailId());
			loanData.setCustomerPermanentAddress(loanEnquiry.getCustomerPermanentAddress());
			loanData.setCustomerCity(loanEnquiry.getCustomerCity());
			loanData.setCustomerPincode(loanEnquiry.getCustomerPincode());
			loanData.setEnquiryDateTime(LocalDate.now());
			
			
			enquiryRepository.save(loanData);

			log.info("Loan Enquiry has been updated successfully for enquiry id = " + enquiryId);
			return "Enquiry updated successfull...!";
		}
		
		return "invalid Id";
		
	}

}
