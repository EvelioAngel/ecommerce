package com.example.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Business logic error")
	protected ResponseEntity<String> handleBusinessException(BusinessException exception) {
		log.error("Business error: ", exception.getMessage());
		return buildErrorResponse(exception, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected ResponseEntity<String> handleGenericException(Exception exception) {
		log.error("Runtime exception: ", exception);
		return buildErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<String> buildErrorResponse(Exception exception, HttpStatus httpStatus) {
		return ResponseEntity.status(httpStatus).body(exception.getMessage());
	}

}
