package kickstarter.view;

import static kickstarter.control.State.*;

import java.io.IOException;

import kickstarter.control.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.exception.ProcessedException;
import kickstarter.view.printer.Printer;
import kickstarter.view.reader.Reader;

public class PaymentView extends AbstractView {
	private static final String INPUT_MESSAGES[] = { "enter your name:", "enter your account number:" };

	public PaymentView(Printer printer, Reader reader) {
		super(printer, reader);
	}

	@Override
	public State getDirection(int item) throws ProcessedException {
		if (item == 0 || item == 1) {
			return PROJECT;
		}
		throw new IncorrectInputException("Unknown item");
	}

	@Override
	protected String getHead() {
		return "---DONATE---";
	}

	@Override
	protected String getMenu() {
		return String.format("%d - %s\r\n", 0, "EXIT");
	}

	@Override
	public int choiceItem(StringBuilder input) throws IncorrectInputException {
		try {
			for (int i = 0; i < 2; i++) {
				view(INPUT_MESSAGES[i]);
				String line = getLine();
				input.append(line);
				if (getItem(line) == 0) {
					return 0;
				}
			}
			return 1;
		} catch (IOException e) {
			throw new IncorrectInputException(e);
		}
	}

	private int getItem(String line) {
		try {
			int item = Integer.parseInt(line);
			if (item == 0) {
				return item;
			}
		} catch (NumberFormatException ignore) {
		}
		return 1;
	}
}
