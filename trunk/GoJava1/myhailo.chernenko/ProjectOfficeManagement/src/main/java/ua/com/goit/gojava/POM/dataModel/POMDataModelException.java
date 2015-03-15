package ua.com.goit.gojava.POM.dataModel;

public class POMDataModelException extends Exception {

	private static final long serialVersionUID = -5905597476803764282L;

	/*public POMDataModelException() {
			super();
	}*/

	public POMDataModelException(String message) {
		super(message);
	}

	/*public POMDataModelException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}*/

	public POMDataModelException(String message, Throwable cause) {
		super(message, cause);
	}

	/*public POMDataModelException(Throwable cause) {
		super(cause);
	}*/

}
