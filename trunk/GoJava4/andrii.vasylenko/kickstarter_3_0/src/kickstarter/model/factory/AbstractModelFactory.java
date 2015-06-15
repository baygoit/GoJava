package kickstarter.model.factory;

import kickstarter.control.State;
import kickstarter.model.Model;

public interface AbstractModelFactory {
	Model getModel(State state);
}
