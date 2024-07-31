package com.example.Account.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Account.Constants.AccountsConstants;
import com.example.Account.DTO.AccountDto;
import com.example.Account.DTO.CustomerDto;
import com.example.Account.DTO.ResponseDto;
import com.example.Account.Service.IAccountService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


//it is the combination @requestbody and @controller
@AllArgsConstructor
@RestController
//it is good practise to add producer
@RequestMapping(path="/api" ,produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountController {
	
	
	private IAccountService accountService;
	
	
	public ResponseEntity<ResponseDto> createAccount(AccountDto accountReq) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
		
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createAccountDetails(@Valid @RequestBody CustomerDto accountReq) {
		System.out.println("Customwer:::::;"+accountReq);
		accountService.createAccount(accountReq);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
		
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<CustomerDto> getCustomerDetails(@RequestParam String mobileNumber){
		CustomerDto cust=accountService.fetchCustomerDetails(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(cust);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<ResponseDto> upDateCustomer(@Valid @RequestBody CustomerDto customer){
		System.out.println("Cust:::"+customer);
		boolean isUpdated=accountService.updateAccount(customer);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
		}else {
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_UPDATE));
		}
	}

	@DeleteMapping("/dele")
	public ResponseEntity<ResponseDto> getCust(@RequestParam String mobileNumber){
		System.out.println("MobileNumber::"+mobileNumber);
		boolean isUpdated=accountService.delete(mobileNumber);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
		}else {
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_UPDATE));
		}
	}
}
