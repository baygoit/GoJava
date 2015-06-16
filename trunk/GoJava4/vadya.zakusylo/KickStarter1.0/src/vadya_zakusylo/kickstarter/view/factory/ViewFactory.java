package vadya_zakusylo.kickstarter.view.factory;

import static vadya_zakusylo.kickstarter.view.factory.State.*;

import java.util.HashMap;
import java.util.Map;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.view.CategoriesView;
import vadya_zakusylo.kickstarter.view.DonateView;
import vadya_zakusylo.kickstarter.view.ErrorCategoriesView;
import vadya_zakusylo.kickstarter.view.ErrorProjectView;
import vadya_zakusylo.kickstarter.view.ErrorProjectsView;
import vadya_zakusylo.kickstarter.view.ErrorStartView;
import vadya_zakusylo.kickstarter.view.ExitView;
import vadya_zakusylo.kickstarter.view.ProjectView;
import vadya_zakusylo.kickstarter.view.ProjectsView;
import vadya_zakusylo.kickstarter.view.QuestionView;
import vadya_zakusylo.kickstarter.view.StartView;
import vadya_zakusylo.kickstarter.view.View;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.Output;

public class ViewFactory {
	private Controller controller;
	private Model model;
	protected Input input;
	protected Output output;
	private Map<State, View> states = new HashMap<>();

	public ViewFactory(Model model, Controller controller, Input input, Output output) {
		this.model = model;
		this.controller = controller;
		this.input = input;
		this.output = output;
		initViews();
	}

	private void initViews() {
		states.put(START, new StartView(model, controller, input, output));
		states.put(CATEGORIES, new CategoriesView(model, controller, input, output));
		states.put(PROJECTS, new ProjectsView(model, controller, input, output));
		states.put(PROJECT, new ProjectView(model, controller, input, output));
		states.put(DONATE, new DonateView(model, controller, input, output));
		states.put(QUESTION, new QuestionView(model, controller, input, output));
		states.put(EXIT, new ExitView(model, controller, input, output));
		states.put(ERROR_START, new ErrorStartView(model, controller, input, output));
		states.put(ERROR_CATEGORIES, new ErrorCategoriesView(model, controller, input, output));
		states.put(ERROR_PROJECTS, new ErrorProjectsView(model, controller, input, output));
		states.put(ERROR_PROJECT, new ErrorProjectView(model, controller, input, output));
	}

	public View getView(State state) {
		return states.get(state);
	}
}