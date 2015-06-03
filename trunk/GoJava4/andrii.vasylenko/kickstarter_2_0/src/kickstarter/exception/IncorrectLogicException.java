package kickstarter.exception;

public class IncorrectLogicException extends Exception {

	private static final long serialVersionUID = -5540164525667251176L;

	public IncorrectLogicException() {
		super();
	}

	public IncorrectLogicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IncorrectLogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public IncorrectLogicException(String message) {
		super(message);
	}

	public IncorrectLogicException(Throwable cause) {
		super(cause);
	}

}
