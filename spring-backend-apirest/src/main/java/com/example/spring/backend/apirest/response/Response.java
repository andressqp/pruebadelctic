package com.example.spring.backend.apirest.response;

public class Response {

	private Boolean isOk;
	
	private Object result;
	
	private String error;
	
	private String message;

	public Response(Boolean isOk, String message) {
		super();
		this.isOk = isOk;
		this.message = message;
	}
	
	public Response() {
		
	}

	public Boolean getIsOk() {
		return isOk;
	}

	public void setIsOk(Boolean isOk) {
		this.isOk = isOk;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
