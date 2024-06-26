package com.example.Account.Service;

import com.example.Account.DTO.AccountDto;
import com.example.Account.DTO.CustomerDto;

public interface IAccountService {
	
	
	/*
	 * @param is mobilenumber
	 * @return is customerDto
	 */
	CustomerDto fetchCustomerDetails(String mobileNumber);

	void createAccount(CustomerDto account);

	boolean updateAccount(CustomerDto customer);
	
	boolean delete(String mobileNumber);

}
