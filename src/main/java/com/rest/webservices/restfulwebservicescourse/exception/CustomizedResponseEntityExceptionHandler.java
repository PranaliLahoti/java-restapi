package com.rest.webservices.restfulwebservicescourse.exception;

import java.net.http.HttpHeaders;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.webservices.restfulwebservicescourse.user.UserNotFoundException;

import io.micrometer.common.lang.Nullable;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorStructure> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ErrorStructure ErrorStructure = new ErrorStructure(LocalDate.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorStructure>(ErrorStructure, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

    @ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorStructure> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorStructure ErrorStructure = new ErrorStructure(LocalDate.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorStructure>(ErrorStructure, HttpStatus.NOT_FOUND);
		
	}

    @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorStructure ErrorStructure = new ErrorStructure(LocalDate.now(), 
        ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(ErrorStructure, HttpStatus.BAD_REQUEST);
		// return handleExceptionInternal(ex, null, headers, status, request);
	}
}
