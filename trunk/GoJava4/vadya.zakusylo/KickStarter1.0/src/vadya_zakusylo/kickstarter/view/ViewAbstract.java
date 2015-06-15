package vadya_zakusylo.kickstarter.view;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.view.factory.State;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.Output;

public abstract class ViewAbstract implements View {
	protected Model model;
	protected Controller controller;
	protected State state;
	protected Input input;
	protected Output output;

	public ViewAbstract(Model model, Controller controller, Input input, Output output) {
		this.model = model;
		this.controller = controller;
		this.input = input;
		this.output = output;
	}
}
