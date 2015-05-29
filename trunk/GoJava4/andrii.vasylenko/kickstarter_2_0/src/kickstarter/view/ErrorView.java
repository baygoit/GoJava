package kickstarter.view;

import java.util.List;

import kickstarter.control.State;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class ErrorView extends ConsoleView {

	public ErrorView(Printer printer, Reader reader) {
		super(printer, reader);
	}

	@Override
	public State getDirection(int item) {
		return null;
	}

	@Override
	protected String getHead() {
		return "---";
	}

	@Override
	protected String getBody(List<String> data) {
		return "try again please!";
	}

	@Override
	protected String getMenu() {
		return "";
	}

}
