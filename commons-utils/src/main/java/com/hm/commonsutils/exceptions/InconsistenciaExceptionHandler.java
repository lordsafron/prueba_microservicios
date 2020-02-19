package com.hm.commonsutils.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
@ControllerAdvice
public class InconsistenciaExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<?> handlerException(InconsistenciaException ex) {
		Map<String, String> error = new HashMap<String, String>();
		error.put("message", ex.getMessage());
		return ResponseEntity.badRequest().body(error);
	}

}
