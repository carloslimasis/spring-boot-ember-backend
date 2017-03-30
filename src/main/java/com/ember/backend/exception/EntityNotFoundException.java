package com.ember.backend.exception;

public class EntityNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6239674733633333434L;

	public EntityNotFoundException(String message) {
		super(message);
	}
}
