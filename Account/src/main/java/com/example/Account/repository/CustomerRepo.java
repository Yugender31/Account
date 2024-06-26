package com.example.Account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Account.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	 
	Optional<Customer> findByMobileNumber(String mobileNumber);
	
	@Query("SELECT c  FROM Customer c  WHERE c.mobileNumber = ?1")
	Customer findByMobileNumber1(String mobile_number);

}
