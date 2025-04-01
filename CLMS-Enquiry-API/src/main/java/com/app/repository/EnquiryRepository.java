package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.LoanEnquiry;

public interface EnquiryRepository extends JpaRepository<LoanEnquiry, Integer> {

	public List<LoanEnquiry> findByEnquiryStatus(String string);

}
