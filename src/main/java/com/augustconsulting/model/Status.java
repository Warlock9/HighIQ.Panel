package com.augustconsulting.model;


public class Status {
	private int code;
	private String message;
	private String digitalWorkerName;

	public Status() {
	}

	public Status(int code, String message,String digitalWorkerName) {
		this.code = code;
		this.message = message;
		this.digitalWorkerName=digitalWorkerName;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDigitalWorkerName() {
		return digitalWorkerName;
	}

	public void setDigitalWorkerName(String digitalWorkerName) {
		this.digitalWorkerName = digitalWorkerName;
	}
	
	
}
