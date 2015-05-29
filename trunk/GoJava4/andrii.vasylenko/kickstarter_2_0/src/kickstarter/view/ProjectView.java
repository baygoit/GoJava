package kickstarter.view;

import static kickstarter.control.State.*;
import kickstarter.control.State;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class ProjectView extends ConsoleView {

	public ProjectView(Printer printer, Reader reader) {
		super(printer, reader);
	}

	@Override
	public State getDirection(int item) {
		if (item == 0) {
			return PROJECTS;
		}
		throw new IllegalArgumentException();
	}

	@Override
	protected String getHead() {
		return "---PROJECT---";
	}

	@Override
	protected String getMenu() {
		StringBuilder result = new StringBuilder();

		result.append(0);
		result.append(" - ");
		result.append("EXIT");
		result.append("\r\n");

		return result.toString();
	}

}
