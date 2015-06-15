package kickstarter.view.factory;

import kickstarter.control.State;
import kickstarter.view.View;

public interface AbstractViewFactory {
	View getView(State state);
}
