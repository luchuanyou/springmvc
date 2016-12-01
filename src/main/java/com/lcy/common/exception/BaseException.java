package com.lcy.common.exception;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2390533972647330454L;

	public String errorCode;
	public String errorMsg;
	
	public BaseException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseException(String errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
}
