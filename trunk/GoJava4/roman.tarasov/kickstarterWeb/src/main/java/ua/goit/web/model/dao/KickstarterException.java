package ua.goit.web.model.dao;

public class KickstarterException extends Exception {

	private static final long serialVersionUID = -2062780015034365123L;
	private String message;

	public KickstarterException(String message) {
		super(message);
		this.message=message;
	}

	public KickstarterException(String message, Throwable throwable) {
		super(message, throwable);
		this.message=message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
