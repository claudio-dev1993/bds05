package com.devsuperior.movieflix.services.exceptions;

public class ForbiddenAccessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ForbiddenAccessException(String msg) {
		super(msg);
	}

}
