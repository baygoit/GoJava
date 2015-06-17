package vadyazakusylo.kickstarter.view;

import vadyazakusylo.kickstarter.controller.Controller;
import vadyazakusylo.kickstarter.model.Model;
import vadyazakusylo.kickstarter.view.factory.State;
import vadyazakusylo.kickstarter.view.input.Input;
import vadyazakusylo.kickstarter.view.output.Output;

public abstract class ViewAbstract implements View {
	State state;
	Model model;
	Controller controller;
	Input input;
	Output output;

	public ViewAbstract(Model model, Controller controller, Input input, Output output) {
		this.model = model;
		this.controller = controller;
		this.input = input;
		this.output = output;
	}
}
