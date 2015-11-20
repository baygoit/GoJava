package ua.com.goit.gojava7.kickstarter.exception;

public class QuestionReadException extends IllegalStateException {
	
	public QuestionReadException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuestionReadException(String message) {
		super(message);
	}
}
