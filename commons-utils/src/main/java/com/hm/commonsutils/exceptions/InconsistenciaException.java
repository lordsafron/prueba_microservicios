package com.hm.commonsutils.exceptions;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
public class InconsistenciaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public InconsistenciaException(String msg) {
		super(msg);
	}

}
