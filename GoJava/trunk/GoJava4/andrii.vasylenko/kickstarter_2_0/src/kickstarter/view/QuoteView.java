package kickstarter.view;

import kickstarter.control.State;

public class QuoteView extends AbstractView {

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
