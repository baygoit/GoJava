package vadyazakusylo.kickstarter.view;

import vadyazakusylo.kickstarter.controller.Controller;
import vadyazakusylo.kickstarter.model.Model;
import vadyazakusylo.kickstarter.view.input.Input;
import vadyazakusylo.kickstarter.view.output.Output;

public abstract class ErrorView extends ViewAbstract {

	public ErrorView(Model model, Controller controller, Input input, Output output) {
		super(model, controller, input, output);
	}

	@Override
	public void printHeader() {
		output.write("----------------------ERROR-----------------------");
	}

	@Override
	public void printContent() {
		output.write();
		output.write("--You have inputted incorrect number or symbols---");
		output.write("----Input 0 for return to the previous window-----");
	}
}