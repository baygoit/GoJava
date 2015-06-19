package vadyazakusylo.kickstarter.view;

import vadyazakusylo.kickstarter.controller.Controller;
import vadyazakusylo.kickstarter.model.Model;
import vadyazakusylo.kickstarter.model.exception.GettingDateException;
import vadyazakusylo.kickstarter.view.factory.State;
import vadyazakusylo.kickstarter.view.input.Input;
import vadyazakusylo.kickstarter.view.output.Output;

public class DonateView extends ViewAbstract {

	public DonateView(Model model, Controller controller, Input input, Output output) {
		super(model, controller, input, output);
	}

	@Override
	public void printHeader() {
		output.write("----------Window of donation to project-----------");
	}

	double donate;

	@Override
	public void printContent() {
		output.write();
		output.write("You may donating on " + model.getProjectChosen().getName());
		output.write(model.getProjectChosen().getShortContent());
		output.write("Input your name");
		input.readString();
		output.write("Input number of your pay card");
		input.readInt();
		do {
			output.write("Input donation (like is 10.0)");
			donate = input.readDouble();
		} while (donate <= 0);
		output.write("\nInput:\n1 - to donate\n0 - to return");
	}

	@Override
	public State chooseDirection() {
		int inputNumber = input.readInt();
		if (inputNumber == 0) {
			state = State.PROJECT;
		} else if (inputNumber == 1) {
			state = State.PROJECT;
			try {
				controller.setCurrentMoney(donate);
			} catch (GettingDateException e) {
				output.write(e);
			}
		} else {
			state = State.ERROR_PROJECT;
		}
		return state;
	}
}