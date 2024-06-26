package com.example.Account.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {
	
	
 private Long customerId;
 @Id
 private Long accountNumber;
 private String accountType;
 private String branchAddress;
 
}
