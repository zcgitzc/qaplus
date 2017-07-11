package com.qaplus.entity.vo;

import java.io.Serializable;
import java.util.List;

import com.qaplus.constant.ErrorCode;

public class ResponseData<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;
	private String msg;
	private List<T> data;
	private boolean hasError;
	private int count;
	

	public ResponseData(ErrorCode errorCode, String msg,
			List<T> data, boolean hasError) {
		super();
		this.errorCode = errorCode;
		this.msg = msg;
		this.data = data;
		this.hasError = hasError;
	}
	
	public ResponseData(List<T> data, int count) {
		super();
		this.data = data;
		this.count = count;
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

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
