package com.floreria.app.controller.utils;

/**
 * 
 * @author kbo99
 *
 */
public class FloreriaBusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1065200140557641943L;

	private String errorCode;

	private String errorMessage;
	
	// Constructors	
	public FloreriaBusinessException() {
		super();
	}

	public FloreriaBusinessException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public FloreriaBusinessException(String errorCode, String errorMessage, Throwable e) {
		super(errorMessage, e);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public FloreriaBusinessException(Throwable e) {
		super(e);
	}

	// Get and Setter
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
