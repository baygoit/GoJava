package ua.com.goit.gojava7.kickstarter.exception;

public class CategoryReadException extends IllegalStateException {

	public CategoryReadException(String message, Throwable cause) {
		super(message, cause);
	}

	public CategoryReadException(String message) {
		super(message);
	}

}
