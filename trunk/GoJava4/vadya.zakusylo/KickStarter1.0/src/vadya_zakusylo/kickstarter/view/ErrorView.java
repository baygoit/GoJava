package vadya_zakusylo.kickstarter.view;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.Output;

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