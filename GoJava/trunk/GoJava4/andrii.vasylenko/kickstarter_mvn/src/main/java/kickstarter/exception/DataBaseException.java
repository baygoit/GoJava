package kickstarter.exception;

public class DataBaseException extends Exception {

	private static final long serialVersionUID = 5050295772371152523L;

	public DataBaseException() {
		super();
	}

	public DataBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DataBaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataBaseException(String message) {
		super(message);
	}

	public DataBaseException(Throwable cause) {
		super(cause);
	}
}
