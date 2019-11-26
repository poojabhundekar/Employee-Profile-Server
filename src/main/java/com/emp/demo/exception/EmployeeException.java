package com.emp.demo.exception;

/**
 * The EmployeeException will be an unchecked Java exception.Can use this code
 * to retrieve localized error messages and to link to our online documentation.
 * 
 * @author Pooja
 */
public class EmployeeException extends RuntimeException {

	private String message;
	private String error;
	private String path;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeException(String message) {
		super(message);
		this.message = message;
	}

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

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}