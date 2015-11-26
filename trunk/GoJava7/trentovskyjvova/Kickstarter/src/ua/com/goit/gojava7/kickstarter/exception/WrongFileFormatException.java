package ua.com.goit.gojava7.kickstarter.exception;

public class WrongFileFormatException extends IllegalStateException {

	public WrongFileFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongFileFormatException(String message) {
		super(message);
	}

}
