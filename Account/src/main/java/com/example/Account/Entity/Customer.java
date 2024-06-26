package com.example.Account.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long customerId;
	
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="mobile_number")
    private String mobileNumber;

}
