package kickstarter.exception;

public class CannotGetDataException extends ProcessedException {

	private static final long serialVersionUID = 5041805647587965295L;

	public CannotGetDataException() {
		super();
	}

	public CannotGetDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CannotGetDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotGetDataException(String message) {
		super(message);
	}

	public CannotGetDataException(Throwable cause) {
		super(cause);
	}
}
