package it.epicode.be.prenotazioni.services;

import org.springframework.core.Ordered;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.epicode.be.prenotazioni.common.exception.ApiError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExeptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(LinguaNonSupportataException.class)
	protected ResponseEntity<Object> handleExeption(LinguaNonSupportataException ex) {
		ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		return builderResponseEntity(apiError);

	}

	private ResponseEntity<Object> builderResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
