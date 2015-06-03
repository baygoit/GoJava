package kickstarter.view;

import static kickstarter.control.State.*;
import kickstarter.control.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class ProjectView extends AbstractView {

	public ProjectView(Printer printer, Reader reader) {
		super(printer, reader);
	}

	@Override
	public State getDirection(int item) throws IncorrectInputException {
		if (item == 0) {
			return PROJECTS;
		}
		throw new IncorrectInputException("Unknown item");
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
