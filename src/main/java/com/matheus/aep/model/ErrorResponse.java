package com.matheus.aep.model;

import lombok.Builder;

@Builder
public class ErrorResponse {
	
	private String mensagem;
	private int httpStatus;
	private Long timeStamp;
	
	public ErrorResponse() {
	}
	
	public ErrorResponse(String mensagem, int httpStatus, Long timeStamp) {
		super();
		this.mensagem = mensagem;
		this.httpStatus = httpStatus;
		this.timeStamp = timeStamp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	
}
