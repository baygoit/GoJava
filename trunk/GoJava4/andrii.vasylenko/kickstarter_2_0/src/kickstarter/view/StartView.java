package kickstarter.view;

import java.util.List;

import kickstarter.control.State;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class StartView extends ConsoleView {

	public StartView(Printer printer, Reader reader) {
		super(printer, reader);
	}

	@Override
	public State getDirection(int item) {
		return State.QUOTE;
	}

	@Override
	protected String getHead() {
		return "!>-KICKSTARTER-<!";
	}

	@Override
	protected String getBody(List<String> data) {
		return "     WELCOME     ";
	}

	@Override
	protected String getMenu() {
		return "";
	}
}
