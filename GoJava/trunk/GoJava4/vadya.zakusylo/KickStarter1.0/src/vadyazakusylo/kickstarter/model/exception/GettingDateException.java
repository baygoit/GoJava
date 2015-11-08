package vadyazakusylo.kickstarter.model.exception;

public class GettingDateException extends RuntimeException{
	/**
	 * Vadya Zakusylo
	 */
	private static final long serialVersionUID = 5306682775635299924L;

	public String toString() {
		return "Problem with connecting to DataBase or\ncontent of your choice is empty";
	}
}
