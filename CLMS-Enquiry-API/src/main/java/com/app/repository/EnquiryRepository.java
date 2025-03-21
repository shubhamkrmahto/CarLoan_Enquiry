package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.LoanEnquiry;

public interface EnquiryRepository extends JpaRepository<LoanEnquiry, Integer> {

}
