package com.emp.manage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@SuppressWarnings("serial")
@ResponseStatus(value =HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
	
	//para constructor
	
	public ResourceNotFound(String message) {
		super(message);
	}
}
