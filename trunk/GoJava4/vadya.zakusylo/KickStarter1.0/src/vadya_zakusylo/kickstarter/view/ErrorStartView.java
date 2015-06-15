package vadya_zakusylo.kickstarter.view;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.view.factory.State;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.Output;

public class ErrorStartView extends ErrorView {

	public ErrorStartView(Model model, Controller controller, Input input, Output output) {
		super(model, controller, input, output);
	}

	@Override
	public State chooseDirection() {
		int inputNumber = input.readInt();
		if (inputNumber == 0) {
			state = State.START;
		} else {
			state = State.ERROR_START;
		}
		return state;
	}
}
