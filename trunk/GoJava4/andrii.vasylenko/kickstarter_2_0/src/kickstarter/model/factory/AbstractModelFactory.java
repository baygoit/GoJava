package kickstarter.model.factory;

import java.util.List;

import kickstarter.control.State;
import kickstarter.model.Model;

public interface AbstractModelFactory {
	Model getInstance(State state, List<Object> parameters);
}
