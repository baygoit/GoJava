package ua.com.goit.gojava.POM.services;

public class POMServecesRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public POMServecesRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public POMServecesRuntimeException(String message) {
		super(message);
	}
	
}
