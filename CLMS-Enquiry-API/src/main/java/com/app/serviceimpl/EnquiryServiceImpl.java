package com.app.serviceimpl;


import java.time.LocalDate;
import java.util.List;
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
		mail.setTo(enquiry.getEmail());
		
		mail.setSubject("Regarding Loan Enquiry");
		mail.setText("Your Loan enquiry request has been Registed.Our Customer executive will reach you out soon. Stay connected ");
		
		mailSender.send(mail);
		return "Enquiry registered";
				
	}

	
	

	@Override
	public String updateFullName(Integer id, String cname) {
		// TODO Auto-generated method stub
		
		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		if(CById.isPresent()) {
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setFullName(cname);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Name has been updated Successfully.";
		}
		return "No valid result found for this id.";
	}

	
	@Override
	public String updateDateOfBirth(Integer id, LocalDate dob) {
		// TODO Auto-generated method stub
		
		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		if(CById.isPresent()) {
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setDateOfBirth(dob);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Date of Birth has been updated Successfully.";
		}
		return "No valid result found for this id.";
	}
	
	@Override
	public String updateGender(Integer id, String gender) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		if(CById.isPresent()) {
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setGender(gender);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Gender has been updated Successfully.";
		}
		return "No valid result found for this id.";
		
	}

	@Override
	public String updateContact(Integer id, Long contact) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		if(CById.isPresent()) {
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setMobileNumber(contact);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Contact Number has been updated Successfully.";
		
		}
		return "No valid result found for this id.";
	}


	@Override
	public String updateAlternate(Integer id, Long alternate) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		if(CById.isPresent()) {
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setAlternateNumber(alternate);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Alternate Contact has been updated Successfully.";
	}
	return "No valid result found for this id.";
	}


	@Override
	public String updateEmail(Integer id, String email) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		if(CById.isPresent()) {
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setEmail(email);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Email has been updated Successfully.";
		}
		return "No valid result found for this id.";
	}



	@Override
	public Optional<LoanEnquiry> findByEnquiryId(int enquiryId, LoanEnquiry loanEnquiry) {
		Optional<LoanEnquiry> loan = enquiryRepository.findById(enquiryId);
		LoanEnquiry loanData = loan.get();
		loanData.setFullName(loanEnquiry.getFullName());
		loanData.setDateOfBirth(loanEnquiry.getDateOfBirth());
		loanData.setGender(loanEnquiry.getGender());
		loanData.setEmail(loanEnquiry.getEmail());
		loanData.setMobileNumber(loanEnquiry.getMobileNumber());
		loanData.setAlternateNumber(loanEnquiry.getAlternateNumber());
		loanData.setEnquiryDateTime(LocalDate.now());
		
		enquiryRepository.save(loanData);
		return Optional.of(loanData);
	}

	@Override
	public LoanEnquiry getSingleEnquiry(Integer id) {
		Optional<LoanEnquiry> byId = enquiryRepository.findById(id);	
		return byId.get();
	}

	@Override
	public List<LoanEnquiry> getAllDataEnquiryOfCustomer() {
		
		return	enquiryRepository.findAll();

	}


	@Override
	public String updateAadharNo(Integer id, Long aadharNo) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		if(CById.isPresent()) {
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setAadharNo(aadharNo);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer Aadhar No has been updated Successfully.";
		}
		return "No valid result found for this id.";
	}


	@Override
	public String updatePanNo(Integer id, Long panNo) {
		// TODO Auto-generated method stub

		Optional<LoanEnquiry> CById = enquiryRepository.findById(id);
		
		if(CById.isPresent()) {
		
		LoanEnquiry loanEnquiry = CById.get();
		
		loanEnquiry.setPanCardNo(panNo);
		
		enquiryRepository.save(loanEnquiry);
		
		return "Customer PanCard No No has been updated Successfully.";
		}
		return "No valid result found for this id.";
	}


}