package kickstarter.view;

import kickstarter.control.State;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class QuoteView extends AbstractView {

	public QuoteView(Printer printer, Reader reader) {
		super(printer, reader);
	}

	@Override
	public State getDirection(int item) {
		return State.CATEGORIES;
	}

	@Override
	protected String getHead() {
		return "---QUOTE---";
	}

	@Override
	protected String getMenu() {
		return "";
	}

}
