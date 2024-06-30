package com.example.Account.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter@ToString
public class CustomerDto {
	
	@NotEmpty(message="name sholud not be empty ")
	private String name;
	@NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
	private String email;
	@NotEmpty
	private String mobileNumber;
	private AccountDto accountDto;

}
