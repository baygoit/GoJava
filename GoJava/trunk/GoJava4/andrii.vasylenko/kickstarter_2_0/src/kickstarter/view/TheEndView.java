package kickstarter.view;

import java.util.List;

import kickstarter.control.State;

public class TheEndView extends AbstractView {

	@Override
	public State getDirection(int item) {
		return State.EXIT;
	}

	@Override
	protected String getHead() {
		return "!>-KICKSTARTER-<!";
	}

	@Override
	protected String getBody(List<String> data) {
		return "   GOOD LUCK!   ";
	}

	@Override
	protected String getMenu() {
		return "";
	}
}
