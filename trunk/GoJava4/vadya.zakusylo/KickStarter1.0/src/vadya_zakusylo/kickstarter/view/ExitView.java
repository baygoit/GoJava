package vadya_zakusylo.kickstarter.view;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.view.factory.State;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.Output;

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
	}

	@Override
	public State chooseDirection() {
		// NOP
		return null;
	}
}