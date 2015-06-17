package vadyazakusylo.kickstarter.view.factory;

import static vadyazakusylo.kickstarter.view.factory.State.*;

import java.util.HashMap;
import java.util.Map;

import vadyazakusylo.kickstarter.controller.Controller;
import vadyazakusylo.kickstarter.model.Model;
import vadyazakusylo.kickstarter.view.CategoriesView;
import vadyazakusylo.kickstarter.view.DonateView;
import vadyazakusylo.kickstarter.view.ErrorCategoriesView;
import vadyazakusylo.kickstarter.view.ErrorProjectView;
import vadyazakusylo.kickstarter.view.ErrorProjectsView;
import vadyazakusylo.kickstarter.view.ErrorStartView;
import vadyazakusylo.kickstarter.view.ExitView;
import vadyazakusylo.kickstarter.view.ProjectView;
import vadyazakusylo.kickstarter.view.ProjectsView;
import vadyazakusylo.kickstarter.view.QuestionView;
import vadyazakusylo.kickstarter.view.StartView;
import vadyazakusylo.kickstarter.view.View;
import vadyazakusylo.kickstarter.view.input.Input;
import vadyazakusylo.kickstarter.view.output.Output;

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