package kickstarter.model.factory;

import kickstarter.control.state.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.model.Model;

public interface ModelFactory {
	/**
	 * initialize Model with DAO by State and return this Model
	 */
	Model getModel(State state) throws IncorrectInputException;
}
