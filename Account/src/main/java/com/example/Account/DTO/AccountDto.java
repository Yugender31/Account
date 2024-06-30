package com.example.Account.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class AccountDto {
	
	@NotEmpty(message="Account number should not be empty")
	private Long accountNumber;
	@NotEmpty(message="Account Type should not be empty")
	private String accountType;
	@NotEmpty(message="branchAddress should not be empty")
	private String branchAddress;


}
