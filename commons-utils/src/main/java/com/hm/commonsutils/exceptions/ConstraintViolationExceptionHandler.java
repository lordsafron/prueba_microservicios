package com.hm.commonsutils.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@ControllerAdvice
public class ConstraintViolationExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<?> handlerException(ConstraintViolationException ex) {
		Map<String, List<String>> error = new HashMap<String, List<String>>();
		error.put("error", prepareMessage(ex));
		return ResponseEntity.badRequest().body(error);
	}
	
	private List<String> prepareMessage(ConstraintViolationException exception) {
		ResourceBundle parametros = ResourceBundle.getBundle("parametros");
		List<String> lMsg = new ArrayList<>();
		for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {

			lMsg.add(parametros.getString(cv.getMessage()));
		}

		return lMsg;
	}

}
