package ua.com.goit.gojava7.kickstarter.exception;

public class PaymentReadException extends IllegalStateException {
	
	public PaymentReadException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentReadException(String message) {
		super(message);
	}
}
