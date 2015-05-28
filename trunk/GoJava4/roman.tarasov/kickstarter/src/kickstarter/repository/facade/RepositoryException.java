package kickstarter.repository.facade;

public class RepositoryException extends Exception {

	private static final long serialVersionUID = 1L;
	String message;

	public RepositoryException(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}
}
