package ua.com.goit.gojava.POM.persistence;

public class POMPersistenceException extends Exception {

	private static final long serialVersionUID = 1L;

	public POMPersistenceException(String message) {
		super(message);
	}

	public POMPersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

}
