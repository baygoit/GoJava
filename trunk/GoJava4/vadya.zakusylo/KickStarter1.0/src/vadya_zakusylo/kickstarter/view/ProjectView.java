package vadya_zakusylo.kickstarter.view;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.view.factory.State;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.Output;

public class ProjectView extends ViewAbstract {

	public ProjectView(Model model, Controller controller, Input input, Output output) {
		super(model, controller, input, output);
	}

	@Override
	public void printHeader() {
		output.write("---------------------Project----------------------");
	}

	@Override
	public void printContent() {
		output.write();
		output.write("You have chosen " + model.getProject().getName());
		output.write(model.getProject().getFullContent());
		output.write("\nInput:\n1 - to donate\n2 - to ask question\n0 - to return");
	}

	@Override
	public State chooseDirection() {
		int inputNumber = input.readInt();
		if (inputNumber == 1) {
			state = State.DONATE;
		} else if (inputNumber == 2) {
			state = State.QUESTION;
		} else if (inputNumber == 0) {
			state = State.PROJECTS;
		} else {
			state = State.ERROR_PROJECT;
		}
		return state;
	}
}