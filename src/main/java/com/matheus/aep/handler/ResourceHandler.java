package com.matheus.aep.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matheus.aep.exception.DocaoException;
import com.matheus.aep.model.ErrorResponse;
import com.matheus.aep.model.ErrorResponse.ErrorResponseBuilder;


@ControllerAdvice
public class ResourceHandler {

	@ExceptionHandler(DocaoException.class)
	public ResponseEntity<ErrorResponse> handlerDoacaoException(DocaoException docaoException){
		ErrorResponseBuilder erro = ErrorResponse.builder();
		erro.httpStatus(docaoException.getHttpStatus().value());
		erro.mensagem(docaoException.getMessage());
		erro.timeStamp(System.currentTimeMillis());
		return ResponseEntity.status(docaoException.getHttpStatus()).body(erro.build());
	}
}
