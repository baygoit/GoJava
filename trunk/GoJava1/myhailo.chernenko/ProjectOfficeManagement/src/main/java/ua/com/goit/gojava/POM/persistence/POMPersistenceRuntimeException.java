package ua.com.goit.gojava.POM.persistence;

public class POMPersistenceRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public POMPersistenceRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public POMPersistenceRuntimeException(String message) {
		super(message);
	}
	
}
