package vadyazakusylo.kickstarter.view;

import vadyazakusylo.kickstarter.controller.Controller;
import vadyazakusylo.kickstarter.model.Model;
import vadyazakusylo.kickstarter.view.factory.State;
import vadyazakusylo.kickstarter.view.input.Input;
import vadyazakusylo.kickstarter.view.output.Output;

public class ExitView extends ViewAbstract {

	public ExitView(Model model, Controller controller, Input input, Output output) {
		super(model, controller, input, output);
	}

	@Override
	public void printHeader() {
		output.write("-------------By! And have a nice day!-------------");
	}

	@Override
	public void printContent() {
		// NOP
		// this method don't call
	}

	@Override
	public State chooseDirection() {
		// NOP
		// this method don't call
		throw new AssertionError();
	}
}