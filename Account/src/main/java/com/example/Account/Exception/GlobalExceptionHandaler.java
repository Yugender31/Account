package com.example.Account.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.Account.DTO.ErrorResponseDto;


@ControllerAdvice
public class GlobalExceptionHandaler {
	

@ExceptionHandler(CustomerAlreadyExistsException.class)
public ResponseEntity<ErrorResponseDto>  handaleCustomerAlreadyExists(CustomerAlreadyExistsException exception, WebRequest webRequest){
	 ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
             webRequest.getDescription(true),
             HttpStatus.BAD_REQUEST,
             exception.getMessage(),
             LocalDateTime.now()
     );
	 
	 return new ResponseEntity<ErrorResponseDto>(errorResponseDTO,HttpStatus.BAD_REQUEST);
}


@ExceptionHandler(ResourseNotFoundException.class)
public ResponseEntity<ErrorResponseDto>  resourseNotFoundException(ResourseNotFoundException exception, WebRequest webRequest){
	 ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
             webRequest.getDescription(true),
             HttpStatus.NOT_FOUND,
             exception.getMessage(),
             LocalDateTime.now()
     );
	 
	 return new ResponseEntity<ErrorResponseDto>(errorResponseDTO,HttpStatus.NOT_FOUND);
}
}
