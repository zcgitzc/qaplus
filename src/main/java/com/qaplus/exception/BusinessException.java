package com.qaplus.exception;

import com.qaplus.constant.ErrorCode;

public class BusinessException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private ErrorCode errorCode;
	
	private String msg;
    
	public BusinessException() {
		
	}
	
	
	public BusinessException(ErrorCode errorCode, String msg) {
		this.msg=msg;
		this.errorCode = errorCode;
	}
	
	public BusinessException(ErrorCode errorCode, String msg,Throwable throwable) {
		super(throwable);
		this.msg=msg;
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
