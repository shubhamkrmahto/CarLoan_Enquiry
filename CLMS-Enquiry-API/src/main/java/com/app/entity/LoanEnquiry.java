package com.app.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class LoanEnquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiryId;
	private String customerName;
	private Long customerContactNumber;
	private Long customerAlternateNumber;
	private String customerEmailId;
	private String customerPermanentAddress;
	private String customerCity;
	private Integer customerPincode;
	
	@CreationTimestamp
	private LocalDate enquiryDateTime;

	

	
}
