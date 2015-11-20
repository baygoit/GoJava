package ua.com.goit.gojava7.kickstarter.exception;

public class QuoteReadException extends IllegalStateException {

	public QuoteReadException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuoteReadException(String message) {
		super(message);
	}

}
