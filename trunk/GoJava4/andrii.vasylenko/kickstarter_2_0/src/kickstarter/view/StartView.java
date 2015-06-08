package kickstarter.view;

import java.util.List;

import kickstarter.control.State;

public class StartView extends AbstractView {

	@Override
	public State getDirection(int item) {
		return State.QUOTE;
	}

	@Override
	protected String getHead() {
		return "!>-KICKSTARTER-<!";
	}

	@Override
	protected String getBody(List<String> data) {
		return "     WELCOME     ";
	}

	@Override
	protected String getMenu() {
		return "";
	}
}
