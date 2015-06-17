package vadyazakusylo.kickstarter.view;

import vadyazakusylo.kickstarter.controller.Controller;
import vadyazakusylo.kickstarter.model.Model;
import vadyazakusylo.kickstarter.view.factory.State;
import vadyazakusylo.kickstarter.view.input.Input;
import vadyazakusylo.kickstarter.view.output.Output;

public class QuestionView extends ViewAbstract {
	String question;

	public QuestionView(Model model, Controller controller, Input input, Output output) {
		super(model, controller, input, output);
	}

	@Override
	public void printHeader() {
		output.write("-------------------Ask question-------------------");
	}

	@Override
	public void printContent() {
		output.write();
		output.write("Enter your question and input enter.");
		question = input.readString();
		output.write("\nInput:\n1 - send the question\n0 - to return");
	}

	@Override
	public State chooseDirection() {
		int inputNumber = input.readInt();
		if (inputNumber == 0) {
			state = State.PROJECT;
		} else if (inputNumber == 1) {
			state = State.PROJECT;
			controller.setQuestion(question);
		} else {
			state = State.ERROR_PROJECT;
		}
		return state;
	}
}
