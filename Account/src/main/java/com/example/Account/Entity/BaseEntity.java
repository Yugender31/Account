package com.example.Account.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter@ToString
public class BaseEntity {
	
	private LocalDateTime createdAt;
	private String  createdBy;
	private LocalDateTime updatedAt;
	private String UpdatedBy;
	

}
