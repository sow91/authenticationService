package com.authenticationService.model;

public class JSONError {

	private String tag;
	private int success;
	private int error;
	private String errorMsg;
	
	public JSONError(int error, String errorMsg, int success) {
		this.error = error;
		this.errorMsg = errorMsg;
		this.success = success;
	}

	
	public JSONError(String tag, int success, int error, String errorMsg) {
		super();
		this.tag = tag;
		this.success = success;
		this.error = error;
		this.errorMsg = errorMsg;
	}

	
	public JSONError(int error, String errorMsg) {
		super();
		this.error = error;
		this.errorMsg = errorMsg;
	}


	public JSONError() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}
	
	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
	
}
