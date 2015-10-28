package kickstarter.view;

import static kickstarter.control.State.*;
import kickstarter.control.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.exception.ProcessedException;

public class AmountView extends AbstractView {

	@Override
	public State getDirection(int item) throws ProcessedException {
		if (item == 0) {
			return PROJECT;
		}
		return PAYMENT;
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
		view("Enter amount:");
		return super.choiceItem(input);
	}
}
