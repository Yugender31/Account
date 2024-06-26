package com.example.Account.Mapper;

import com.example.Account.DTO.AccountDto;
import com.example.Account.Entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountDto,Account account) {
		account.setAccountNumber(accountDto.getAccountNumber());
		account.setAccountType(accountDto.getAccountType());
		account.setBranchAddress(accountDto.getBranchAddress());
		return account;
	}
	
	public static AccountDto mapToAccountDto(AccountDto accountDto,Account account) {
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setAccountType(account.getAccountType());
		accountDto.setBranchAddress(account.getBranchAddress());
		return accountDto;
	}

}
