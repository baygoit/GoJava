package kickstarter.view.factory;

import static kickstarter.control.state.State.*;

import java.util.HashMap;
import java.util.Map;

import kickstarter.control.state.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.view.CategoriesView;
import kickstarter.view.ProjectView;
import kickstarter.view.ProjectsView;
import kickstarter.view.QuoteView;
import kickstarter.view.View;

public class ViewFactoryImpl implements ViewFactory {
	private static volatile ViewFactory instance;

	private static final Map<State, View> states = new HashMap<>();

	static {
		states.put(QUOTE, new QuoteView());
		states.put(CATEGORIES, new CategoriesView());
		states.put(PROJECTS, new ProjectsView());
		states.put(PROJECT, new ProjectView());
	}

	public static ViewFactory getInstance() {
		if (instance == null) {
			synchronized (ViewFactoryImpl.class) {
				if (instance == null) {
					instance = new ViewFactoryImpl();
				}
			}
		}
		return instance;
	}

	private ViewFactoryImpl() {
	}

	@Override
	public View getView(State state) throws IncorrectInputException {
		if (state == null) {
			throw new IncorrectInputException("state is null");
		}

		return states.get(state);
	}
}
