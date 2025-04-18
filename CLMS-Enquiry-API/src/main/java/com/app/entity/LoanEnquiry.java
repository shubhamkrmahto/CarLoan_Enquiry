package com.app.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class LoanEnquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiryId;
	private String customerName;
	private LocalDate dateOfBirth;
	private String gender;
	private String customerEmailId;
	private Long customerContactNumber;
	private Long customerAlternateNumber;
	private Long aadharNo;
	private String panCardNo;
	private String enquiryStatus;
	@OneToOne
	private Cibil cibil;
	
	@CreationTimestamp
	private LocalDate enquiryDateTime;
	
}
