package ua.com.goit.gojava.POM.presentation;

public class POMPresentationRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public POMPresentationRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public POMPresentationRuntimeException(String message) {
		super(message);
	}
	
}
