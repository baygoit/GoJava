package kickstarter.view;

import static kickstarter.control.State.*;
import kickstarter.control.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class AskQuestionView extends AbstractView {

	public AskQuestionView(Printer printer, Reader reader) {
		super(printer, reader);
	}

	@Override
	public State getDirection(int item) throws IncorrectInputException {
		if (item == 0) {
			return PROJECT;
		}
		throw new IncorrectInputException("Unknown item");	
	}

	@Override
	protected String getHead() {
		return "---QUESTION---\r\nenter a question please";
	}

	@Override
	protected String getMenu() {
		return "";
	}

}
