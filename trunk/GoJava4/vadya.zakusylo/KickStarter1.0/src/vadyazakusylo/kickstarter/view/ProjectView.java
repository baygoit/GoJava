package vadyazakusylo.kickstarter.view;

import vadyazakusylo.kickstarter.controller.Controller;
import vadyazakusylo.kickstarter.model.Model;
import vadyazakusylo.kickstarter.view.factory.State;
import vadyazakusylo.kickstarter.view.input.Input;
import vadyazakusylo.kickstarter.view.output.Output;

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