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
	private String fullName;
	private LocalDate dateOfBirth;
//	private Integer age;
	private String gender;
	private String email;
	private Long mobileNumber;
	private Long alternateNumber;
//	private String permanentAddress;
//	private String city;
//	private String state;
	private Long aadharNo;
	private Long  panCardNo;
	
	@CreationTimestamp
	private LocalDate enquiryDateTime;

	
//	{
//		
//		"fullName":"Shubham Kumar Mahto",
//		"dateOfBirth":"2002-09-06",
//		"gender":"Male",
//		"email":"skok9258@gmail.com",
//		"mobileNumber":9191919198,
//		"alternateNumber":7878787876,
//		"aadharNo":123412341234,
//		"panCardNo"18726716:
//		
//	}
	
}
