package vadyazakusylo.kickstarter.view;

import vadyazakusylo.kickstarter.controller.Controller;
import vadyazakusylo.kickstarter.model.Model;
import vadyazakusylo.kickstarter.model.exception.GettingDateException;
import vadyazakusylo.kickstarter.view.factory.State;
import vadyazakusylo.kickstarter.view.input.Input;
import vadyazakusylo.kickstarter.view.output.Output;

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
		try {
			output.write();
			output.write(model.getQuote().getQuote());
		} catch (GettingDateException | IndexOutOfBoundsException e) {
			output.write();
		}
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
