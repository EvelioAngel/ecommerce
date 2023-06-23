package com.example.ecommerce.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -5587258839416627484L;

	public BusinessException(String message) {
		super(message);
	}
}
