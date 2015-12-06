package ua.com.goit.gojava7.kickstarter.exception;

public class IODatabaseException extends IllegalStateException {
	
	public IODatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public IODatabaseException(String message) {
		super(message);
	}
	
}
