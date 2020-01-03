package com.demo.model;

public class ExceptionResponse {

	private String message;
	private String reqUri;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReqUri() {
		return reqUri;
	}
	public void setReqUri(String reqUri) {
		this.reqUri = reqUri;
	}
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExceptionResponse(String message, String reqUri) {
		super();
		this.message = message;
		this.reqUri = reqUri;
	}
	
	
}
