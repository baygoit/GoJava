package ua.com.goit.gojava.POM.dataModel;

public class POMDataModelRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -8407850001993976393L;

	/*public POMDataModelRuntimeException() {
		super();
	}

	public POMDataModelRuntimeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}*/

	public POMDataModelRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/*public POMDataModelRuntimeException(String message) {
		super(message);
	}

	public POMDataModelRuntimeException(Throwable cause) {
		super(cause);
	}*/

	
}
