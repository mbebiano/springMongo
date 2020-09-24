package br.com.ntendencia.services.exception;

import java.util.NoSuchElementException;

public class ObjectNotFoundException extends NoSuchElementException {

	private static final long serialVersionUID = 1L;
	
	//sobrepor
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
