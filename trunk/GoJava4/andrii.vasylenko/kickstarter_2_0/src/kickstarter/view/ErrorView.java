package kickstarter.view;

import java.util.List;

import kickstarter.control.State;

public class ErrorView extends AbstractView {

	@Override
	public State getDirection(int item) {
		return null;
	}

	@Override
	protected String getHead() {
		return "---";
	}

	@Override
	protected String getBody(List<String> data) {
		return "try again please!";
	}

	@Override
	protected String getMenu() {
		return "";
	}

}
