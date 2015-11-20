package ua.com.goit.gojava7.kickstarter.exception;

public class ProjectReadException extends IllegalStateException {
	
	public ProjectReadException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProjectReadException(String message) {
		super(message);
	}
}
