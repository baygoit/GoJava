package dao.bank;



public class BankException extends Exception {

	private static final long serialVersionUID = 1L;
	String message;

	public BankException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
