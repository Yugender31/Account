package com.example.Account.ServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.Account.Constants.AccountsConstants;
import com.example.Account.DTO.AccountDto;
import com.example.Account.DTO.CustomerDto;
import com.example.Account.Entity.Account;
import com.example.Account.Entity.Customer;
import com.example.Account.Exception.CustomerAlreadyExistsException;
import com.example.Account.Exception.ResourseNotFoundException;
import com.example.Account.Mapper.AccountMapper;
import com.example.Account.Mapper.CustomerMapper;
import com.example.Account.Service.IAccountService;
import com.example.Account.repository.AccountRepo;
import com.example.Account.repository.CustomerRepo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class AccountServiceImpl implements IAccountService {
	/*
	 * here we created a no arg constructor so it have only one constructor so no
	 * need to add @autowired to that constructor it wil automatically injects the
	 * beans
	 */ 
	private CustomerRepo customerRepo;
	private AccountRepo accountRepo;
	
	
	@Override
	public void createAccount(CustomerDto account) {
		System.out.println("into dao");
		Customer cust = CustomerMapper.mapToCustomer(account, new Customer());
		cust.setCreatedAt(LocalDateTime.now());
		cust.setCreatedBy("anonumous");
		Optional<Customer> isMobileExists = customerRepo.findByMobileNumber(account.getMobileNumber());
		if (isMobileExists.isPresent())
			throw new CustomerAlreadyExistsException(
					"Customer already Esixts with same number::" + account.getMobileNumber());
		System.out.println("into dao::" + cust);
		Customer custdetails = customerRepo.save(cust);

		accountRepo.save(createAccountDetails(custdetails));
	}


	private Account createAccountDetails(Customer custdetails) {
		Account account = new Account();
		long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
		account.setCustomerId(custdetails.getCustomerId());
		account.setAccountNumber(randomAccNumber);
		account.setAccountType(AccountsConstants.SAVINGS);
		account.setBranchAddress(AccountsConstants.ADDRESS);
		account.setCreatedAt(LocalDateTime.now());
		account.setCreatedBy("anonumous");
		return account;
	}


	@Override
	public CustomerDto fetchCustomerDetails(String mobileNumber) {
		Customer custe = customerRepo.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourseNotFoundException("Customer", "mobileNumber", mobileNumber));
		Account account = accountRepo.findByCustomerId(custe.getCustomerId())
				.orElseThrow(() -> new ResourseNotFoundException("Customer", "mobileNumber", mobileNumber));
		CustomerDto customer = CustomerMapper.mapToCustomerDto(custe, new CustomerDto());
		customer.setAccountDto(AccountMapper.mapToAccountDto(new AccountDto(), account));
		return customer;
	}


	@Override
	public boolean updateAccount(CustomerDto customerDto) {
		boolean isUpdated = false;
		System.out.println("AccountDetails:: "+customerDto.getAccountDto());
		AccountDto accountDto = customerDto.getAccountDto();
		if (accountDto != null) {
			Account account = accountRepo.findById(accountDto.getAccountNumber())
					.orElseThrow(() -> new ResourseNotFoundException("Account", "notfount",
							accountDto.getAccountNumber().toString()));
			accountRepo.save(AccountMapper.mapToAccount(accountDto, account));
			Customer customer = customerRepo.findById(account.getCustomerId()).orElseThrow(
					() -> new ResourseNotFoundException("CustomerId", "Not found", account.getCustomerId().toString()));
			 CustomerMapper.mapToCustomer(customerDto,customer);
			customerRepo.save(customer);
			isUpdated = true;
		}
		return isUpdated;
	}


	@Override
	public boolean delete(String mobileNumber) {
		System.out.println("mobile:::"+mobileNumber);
		Customer isMobileExists = customerRepo.findByMobileNumber1(mobileNumber);
		System.out.println("isPresnet:::"+isMobileExists);
		accountRepo.deleteByCustomerId(isMobileExists.getCustomerId());
		customerRepo.deleteById(isMobileExists.getCustomerId());
		return true;
	}

}
