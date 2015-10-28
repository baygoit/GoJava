package kickstarter.interfaces.printers;

public class TestPrinter implements Printer {

	private StringBuilder result = new StringBuilder();

	@Override
	public void showMessage(String message) {
		result.append(message);
		result.append("\r\n");
	}

	public String getResult() {
		return result.toString();
	}

}
