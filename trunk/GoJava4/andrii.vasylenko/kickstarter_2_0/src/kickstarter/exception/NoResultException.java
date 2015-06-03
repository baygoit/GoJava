package kickstarter.exception;

public class NoResultException extends Exception {

	private static final long serialVersionUID = -8335253603803832562L;

	public NoResultException() {
		super();
	}

	public NoResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoResultException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoResultException(String message) {
		super(message);
	}

	public NoResultException(Throwable cause) {
		super(cause);
	}

}
