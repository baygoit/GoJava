package vadya_zakusylo.kickstarter.view;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.view.factory.State;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.Output;

public class CategoriesView extends ViewAbstract {

	public CategoriesView(Model model, Controller controller, Input input, Output output) {
		super(model, controller, input, output);
	}

	@Override
	public void printHeader() {
		output.write("------------Choose one of the category------------");
	}

	@Override
	public void printContent() {
		output.write();
		for (int oneCategory = 1; oneCategory <= model.selectCategories().size(); oneCategory++) {
			output.write(oneCategory + ". "
					+ model.selectCategories().get(oneCategory - 1).getName());
		}
		output.write("\n0. Return");
	}

	@Override
	public State chooseDirection() {
		int inputNumber = input.readInt();
		if (inputNumber == 0) {
			state = State.START;
		} else if (inputNumber > 0 && inputNumber <= model.selectCategories().size()) {
			state = State.PROJECTS;
			setCategory(inputNumber - 1);
		} else {
			state = State.ERROR_CATEGORIES;
		}
		return state;
	}

	private void setCategory(int inputNumber) {
		controller.setCategory(model.selectCategories().get(inputNumber));
	}
}