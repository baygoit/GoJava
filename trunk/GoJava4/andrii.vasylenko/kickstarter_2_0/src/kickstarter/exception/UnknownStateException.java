package kickstarter.exception;

public class UnknownStateException extends Exception {

	private static final long serialVersionUID = -7163241327310699263L;

	public UnknownStateException() {
		super();
	}

	public UnknownStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnknownStateException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownStateException(String message) {
		super(message);
	}

	public UnknownStateException(Throwable cause) {
		super(cause);
	}

}
