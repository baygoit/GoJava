package vadya_zakusylo.kickstarter.view;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.view.factory.State;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.Output;

public class DonateView extends ViewAbstract {
	double donate;

	public DonateView(Model model, Controller controller, Input input, Output output) {
		super(model, controller, input, output);
	}

	@Override
	public void printHeader() {
		output.write("----------Window of donation to project-----------");
	}

	@Override
	public void printContent() {
		output.write();
		output.write("You may donating on " + model.getProject().getName());
		output.write(model.getProject().getShortContent());
		output.write("Input your name");
		input.readString();
		output.write("Input number of your pay card");
		input.readInt();
		output.write("Input donation (like is 10.0)");
		donate = input.readDouble();
		output.write("\nInput:\n1 - to donate\n0 - to return");
	}

	@Override
	public State chooseDirection() {
		int inputNumber = input.readInt();
		if (inputNumber == 0) {
			state = State.PROJECT;
		} else if (inputNumber == 1) {
			state = State.PROJECT;
			controller.setCurrentMoney(donate);
		} else {
			state = State.ERROR_PROJECT;
		}
		return state;
	}
}