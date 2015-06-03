package kickstarter.view.factory;

import kickstarter.control.State;
import kickstarter.exception.UnknownStateException;
import kickstarter.view.View;

public interface AbstractViewFactory {
	View getInstance(State state) throws UnknownStateException;
}
