package com.example.Account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.example.Account.Entity.Account;

import jakarta.transaction.Transactional;

public interface AccountRepo extends JpaRepository<Account, Long> {

	Optional<Account> findByCustomerId(Long customerId);

	/*
	 * This is a Custom DML operation so we need to add @Trascational annotaion to
	 * commit out changes in Db
	 */
	
	@Transactional
	@Modifying 
	/*
				 * This Annotation tells the springframework that this methos the formforming
				 * some modification so please perform @tramnsacational on ythis method
				 */
	void deleteByCustomerId(Long customerId);

}
