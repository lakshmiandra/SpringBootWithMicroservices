package com.example.demo.exception;

import java.util.Date;

public class ExceptionDetails {
	
	
	
	public ExceptionDetails(Date timesStamp, String message, String details) {
		super();
		this.timesStamp = timesStamp;
		this.message = message;
		this.details = details;
	}
	private Date timesStamp;
	private String message;
	private String details;
	public Date getTimesStamp() {
		return timesStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	

}
