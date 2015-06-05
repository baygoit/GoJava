package kickstarter.view;

import static kickstarter.control.State.*;
import kickstarter.control.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.exception.ProcessedException;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class DonateView extends AbstractView {

	public DonateView(Printer printer, Reader reader) {
		super(printer, reader);
	}

	@Override
	public State getDirection(int item) throws ProcessedException {
		if (item == 0) {
			return PROJECT;
		} else if (item == 1) {
			return AMOUNT;
		}
		return PAYMENT;
	}

	@Override
	protected String getHead() {
		return "---DONATE---";
	}

	@Override
	protected String getMenu() {
		StringBuilder result = new StringBuilder();

		String format = "%d - %s\r\n";

		result.append(String.format(format, 1, "Enter other amount"));
		result.append(String.format(format, 0, "EXIT"));

		return result.toString();
	}

	@Override
	public int choiceItem(StringBuilder input) throws IncorrectInputException {
		view("Choose a payment variant please");
		return super.choiceItem(input);
	}
}
