package com.example.Account.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException {
	
	public ResourseNotFoundException(String resource,String fieldName,String filed) {
		super(String.format("%s this resourse is not fount %s:%s",resource, fieldName,filed));
	}
	
	

}
