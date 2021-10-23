package com.online.todolist.exception;

import lombok.Data;

@Data
public class ServiceError {
	/**
	 * The error code.
	 */
	private String errorCode;
	/**
	 * The error message.
	 */
	private String message;
	
	public ServiceError(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.message = errorMessage;
	}

	public ServiceError() {

	}

}
