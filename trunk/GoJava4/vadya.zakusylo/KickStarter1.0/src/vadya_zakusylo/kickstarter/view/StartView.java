package vadya_zakusylo.kickstarter.view;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.view.factory.State;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.Output;

public class StartView extends ViewAbstract {

	public StartView(Model model, Controller controller, Input input, Output output) {
		super(model, controller, input, output);
	}

	@Override
	public void printHeader() {
		output.write("--------------Welcome to KickStarter--------------");
	}

	@Override
	public void printContent() {
		output.write();
		output.write(model.getQuote().getQuote());
		output.write("\nInput:\n1 - to start\n0 - to exit");
	}

	@Override
	public State chooseDirection() {
		int inputNumber = input.readInt();
		if (inputNumber == 1) {
			state = State.CATEGORIES;
		} else if (inputNumber == 0) {
			state = State.EXIT;
		} else {
			state = State.ERROR_START;
		}
		return state;
	}
}
