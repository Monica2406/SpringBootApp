package com.learning.SpringBootApp.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

import com.learning.SpringBootApp.PayLoad.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		boolean status = false;
		ApiResponse apiResponse = new ApiResponse(message,status);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);	
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
		Map<String,String> map = new HashMap<>();
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		allErrors.forEach(error->{
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			map.put(fieldName,message);
		});
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		
	}
	

}
