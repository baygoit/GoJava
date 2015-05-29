package kickstarter.view;

import java.util.List;

import kickstarter.control.State;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class TheEndView extends ConsoleView {

	public TheEndView(Printer printer, Reader reader) {
		super(printer, reader);
	}

	@Override
	public State getDirection(int item) {
		return State.EXIT;
	}

	@Override
	protected String getHead() {
		return "!>-KICKSTARTER-<!";
	}

	@Override
	protected String getBody(List<String> data) {
		return "   GOOD LUCK!   ";
	}

	@Override
	protected String getMenu() {
		return "";
	}
}
