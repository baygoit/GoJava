package kickstarter.exception;

public class CannotCreateTableException extends Exception {

	private static final long serialVersionUID = -3369207895171570438L;

	public CannotCreateTableException() {
		super();
	}

	public CannotCreateTableException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CannotCreateTableException(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotCreateTableException(String message) {
		super(message);
	}

	public CannotCreateTableException(Throwable cause) {
		super(cause);
	}

}
