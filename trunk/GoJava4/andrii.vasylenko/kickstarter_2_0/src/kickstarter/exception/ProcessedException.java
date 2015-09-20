package kickstarter.exception;

public class ProcessedException extends Exception {

	private static final long serialVersionUID = -1151757201750030150L;

	public ProcessedException() {
		super();
	}

	public ProcessedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProcessedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProcessedException(String message) {
		super(message);
	}

	public ProcessedException(Throwable cause) {
		super(cause);
	}
}
