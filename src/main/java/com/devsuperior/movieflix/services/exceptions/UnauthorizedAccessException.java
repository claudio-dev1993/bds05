package com.devsuperior.movieflix.services.exceptions;

public class UnauthorizedAccessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UnauthorizedAccessException(String msg) {
		super(msg);
	}

}
