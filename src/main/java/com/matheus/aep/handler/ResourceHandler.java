package com.matheus.aep.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matheus.aep.exception.DocaoException;
import com.matheus.aep.model.ErrorMapResponse;
import com.matheus.aep.model.ErrorMapResponse.ErrorMapResponseBuilder;
import com.matheus.aep.model.ErrorResponse;
import com.matheus.aep.model.ErrorResponse.ErrorResponseBuilder;

@ControllerAdvice
public class ResourceHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMapResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException m) {

		Map<String, String> erros = new HashMap<>();
		m.getBindingResult().getAllErrors().forEach(erro -> {
			String campo = ((FieldError) erro).getField();
			String mensagem = erro.getDefaultMessage();
			erros.put(campo, mensagem);
		});
		ErrorMapResponseBuilder errorMap = ErrorMapResponse.builder();
		errorMap.erros(erros).httpStatus(HttpStatus.BAD_REQUEST.value()).timeStamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap.build());

	}

	@ExceptionHandler(DocaoException.class)
	public ResponseEntity<ErrorResponse> handlerDoacaoException(DocaoException docaoException) {
		ErrorResponseBuilder erro = ErrorResponse.builder();
		erro.httpStatus(docaoException.getHttpStatus().value());
		erro.mensagem(docaoException.getMessage());
		erro.timeStamp(System.currentTimeMillis());
		return ResponseEntity.status(docaoException.getHttpStatus()).body(erro.build());
	}
}
