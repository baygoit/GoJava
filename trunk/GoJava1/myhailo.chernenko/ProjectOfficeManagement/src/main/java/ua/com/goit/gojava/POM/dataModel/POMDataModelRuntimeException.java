package ua.com.goit.gojava.POM.dataModel;

public class POMDataModelRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public POMDataModelRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public POMDataModelRuntimeException(String message) {
		super(message);
	}
	
}
