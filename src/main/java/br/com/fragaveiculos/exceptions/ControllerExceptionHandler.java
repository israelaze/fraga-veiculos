package br.com.fragaveiculos.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	//Status code 500
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<StandardError> exception(Exception e, HttpServletRequest request){
		
		Integer status = HttpStatus.INTERNAL_SERVER_ERROR.value();
		String error = "ERRO";
		
		StandardError standardError = new StandardError(Instant.now(), status, error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(standardError);
	}
	
	//Status code 400
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest request){
		
		Integer status = HttpStatus.BAD_REQUEST.value();
		String error = "ERRO";
		
		StandardError standardError = new StandardError(Instant.now(), status, error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
	}

	//Status code 404
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
		
		Integer status = HttpStatus.NOT_FOUND.value();
		String error = "ERRO";
		
		StandardError standardError = new StandardError(Instant.now(), status, error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}
	
	//Status code 422
	@ExceptionHandler(UnprocessableEntityException.class)
	public ResponseEntity<StandardError> unprocessable(UnprocessableEntityException e, HttpServletRequest request){
		
		Integer status = HttpStatus.UNPROCESSABLE_ENTITY.value();
		String error = "ERRO";
		
		StandardError standardError = new StandardError(Instant.now(), status, error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(standardError);
	}
}
