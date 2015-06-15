package kickstarter.view.factory;

import static kickstarter.control.State.*;

import java.util.HashMap;
import java.util.Map;

import kickstarter.control.State;
import kickstarter.model.factory.ModelFactory;
import kickstarter.view.CategoriesView;
import kickstarter.view.ProjectView;
import kickstarter.view.ProjectsView;
import kickstarter.view.QuoteView;
import kickstarter.view.View;

public class ViewFactory implements AbstractViewFactory {
	private static volatile AbstractViewFactory instance;

	private static final Map<State, View> states = new HashMap<>();

	static {
		states.put(QUOTE, new QuoteView());
		states.put(CATEGORIES, new CategoriesView());
		states.put(PROJECTS, new ProjectsView());
		states.put(PROJECT, new ProjectView());
	}

	public static AbstractViewFactory getInstance() {
		if (instance == null) {
			synchronized (ModelFactory.class) {
				if (instance == null) {
					instance = new ViewFactory();
				}
			}
		}
		return instance;
	}

	private ViewFactory() {
	}

	@Override
	public View getView(State state) {
		return states.get(state);
	}
}
