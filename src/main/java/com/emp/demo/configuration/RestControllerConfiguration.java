package com.emp.demo.configuration;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * @author Pooja
 *
 */
@RestControllerAdvice
public class RestControllerConfiguration {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exceptionHandler(Exception ex, WebRequest requset) {

		ExceptionBuilder exceptionBuilder = new ExceptionBuilder();

		// Handle All Field Validation Errors
		if (ex instanceof MethodArgumentNotValidException) {
			List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
			fieldErrors.stream().filter(error -> Objects.nonNull(error.getDefaultMessage())).findFirst()
					.ifPresent(msg -> exceptionBuilder.setMessage(msg.getDefaultMessage()));

		} else {
			exceptionBuilder.setMessage(ex.getLocalizedMessage());
		}

		exceptionBuilder.setError(ex.getClass().getCanonicalName());
		exceptionBuilder.setPath(((ServletWebRequest) requset).getRequest().getServletPath());

		return new ResponseEntity<>(exceptionBuilder, null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

/**
 * To set all required variables and send it to UI
 * 
 * @author Pooja
 *
 */
class ExceptionBuilder {
	private String message;
	private String error;
	private String path;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}