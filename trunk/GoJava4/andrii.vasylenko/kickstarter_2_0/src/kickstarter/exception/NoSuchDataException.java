package kickstarter.exception;

public class NoSuchDataException extends ProcessedException {

	private static final long serialVersionUID = -4066897356939724360L;

	public NoSuchDataException() {
		super();
	}

	public NoSuchDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoSuchDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchDataException(String message) {
		super(message);
	}

	public NoSuchDataException(Throwable cause) {
		super(cause);
	}
}
