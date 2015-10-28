package kickstarter.view.printer;

public class ConsolePrinter implements Printer {

	@Override
	public void showMessage(String message) {
		System.out.println(message);
	}

}
