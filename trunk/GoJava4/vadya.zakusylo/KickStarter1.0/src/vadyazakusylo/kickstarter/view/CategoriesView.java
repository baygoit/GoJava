package vadyazakusylo.kickstarter.view;

import java.util.List;

import vadyazakusylo.kickstarter.controller.Controller;
import vadyazakusylo.kickstarter.model.Category;
import vadyazakusylo.kickstarter.model.Model;
import vadyazakusylo.kickstarter.model.exception.GettingDateException;
import vadyazakusylo.kickstarter.view.factory.State;
import vadyazakusylo.kickstarter.view.input.Input;
import vadyazakusylo.kickstarter.view.output.Output;

public class CategoriesView extends ViewAbstract {

	public CategoriesView(Model model, Controller controller, Input input, Output output) {
		super(model, controller, input, output);
	}

	@Override
	public void printHeader() {
		output.write("------------Choose one of the category------------");
	}

	List<Category> categoriesList;

	@Override
	public void printContent() {
		try {
			output.write();
			categoriesList = model.getCategoriesList();
			printCategoriesList();
		} catch (GettingDateException e) {
			output.write();
			output.write(e);
		}
		output.write("\n0. Return");
	}

	private void printCategoriesList() {
		for (int oneCategory = 1; oneCategory <= categoriesList.size(); oneCategory++) {
			output.write(oneCategory + ". " + categoriesList.get(oneCategory - 1).getName());
		}
	}

	@Override
	public State chooseDirection() {
		int inputNumber = input.readInt();
		if (inputNumber == 0) {
			state = State.START;
		} else if (inputNumber > 0 && inputNumber <= categoriesList.size()) {
			state = State.PROJECTS;
			setWorkingCategory(inputNumber - 1);
		} else {
			state = State.ERROR_CATEGORIES;
		}
		return state;
	}

	private void setWorkingCategory(int inputNumber) {
		controller.setWorkingCategory(categoriesList.get(inputNumber));
	}
}