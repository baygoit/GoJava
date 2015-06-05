package kickstarter.view;

import static kickstarter.control.State.*;
import kickstarter.control.State;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class ProjectsView extends AbstractView {

	public ProjectsView(Printer printer, Reader reader) {
		super(printer, reader);
	}

	@Override
	public State getDirection(int item) {
		if (item == 0) {
			return CATEGORIES;
		}
		return PROJECT;
	}

	@Override
	protected String getHead() {
		return "---CHOICE PROJECT---";
	}

	@Override
	protected String getMenu() {
		return String.format("%d - %s\r\n", 0, "EXIT");
	}
}
