package kickstarter.view.factory;

import kickstarter.control.state.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.view.View;

public interface ViewFactory {
	/**
	 * initialize View by State and return this View
	 */
	View getView(State state) throws IncorrectInputException;
}
