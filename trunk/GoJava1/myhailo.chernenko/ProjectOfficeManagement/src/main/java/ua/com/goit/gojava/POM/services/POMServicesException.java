package ua.com.goit.gojava.POM.services;

public class POMServicesException extends Exception {

	private static final long serialVersionUID = 1L;

	public POMServicesException(String message) {
		super(message);
	}

	public POMServicesException(String message, Throwable cause) {
		super(message, cause);
	}

}
