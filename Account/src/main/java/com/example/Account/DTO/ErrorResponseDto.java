package com.example.Account.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorResponseDto {
	
	
	private  String apiPath;
	private HttpStatusCode statusCode;
	private String code;
	private LocalDateTime time;

}
