package com.test.productmgmt.exception.handler;

import com.test.productmgmt.util.Error;
import com.test.productmgmt.util.Errors;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
    Errors handleException(EmptyResultDataAccessException exception) {
		return generateErrorObject(HttpStatus.NOT_FOUND + "", exception.getMessage(), null, exception.getMessage());
	}

	/**
	 * @param exception
	 * @param notFound
	 * @return
	 */
	private Errors generateErrorObject(String errorCode, String message, String field, String description) {
		Errors errorObject = new Errors();
		errorObject.add(new Error(errorCode, message, description, field));
		return errorObject;
	}
}
