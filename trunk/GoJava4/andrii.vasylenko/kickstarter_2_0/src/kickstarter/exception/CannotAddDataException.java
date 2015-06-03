package kickstarter.exception;

public class CannotAddDataException extends Exception {

	private static final long serialVersionUID = 9223217264541178374L;

	public CannotAddDataException() {
		super();
	}

	public CannotAddDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CannotAddDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotAddDataException(String message) {
		super(message);
	}

	public CannotAddDataException(Throwable cause) {
		super(cause);
	}
}
