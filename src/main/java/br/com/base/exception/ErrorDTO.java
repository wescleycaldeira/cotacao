package br.com.base.exception;

import java.time.LocalDateTime;

public class ErrorDTO {
	
	private String errorDescription;
	private Integer statusCode;
	private LocalDateTime momentError;
	
	
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	public LocalDateTime getMomentError() {
		return this.momentError;
	}

	public void setMomentError(LocalDateTime momentError) {
		this.momentError = momentError;
	}
	
}
