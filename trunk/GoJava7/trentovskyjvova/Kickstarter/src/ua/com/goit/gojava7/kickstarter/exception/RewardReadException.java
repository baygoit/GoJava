package ua.com.goit.gojava7.kickstarter.exception;

public class RewardReadException extends IllegalStateException {
	
	public RewardReadException(String message, Throwable cause) {
		super(message, cause);
	}

	public RewardReadException(String message) {
		super(message);
	}
}
