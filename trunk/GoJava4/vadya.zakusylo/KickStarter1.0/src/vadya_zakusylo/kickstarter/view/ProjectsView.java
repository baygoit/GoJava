package vadya_zakusylo.kickstarter.view;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.model.Category;
import vadya_zakusylo.kickstarter.model.Model;
import vadya_zakusylo.kickstarter.view.factory.State;
import vadya_zakusylo.kickstarter.view.input.Input;
import vadya_zakusylo.kickstarter.view.output.Output;

public class ProjectsView extends ViewAbstract {

	public ProjectsView(Model model, Controller controller, Input input, Output output) {
		super(model, controller, input, output);
	}

	@Override
	public void printHeader() {
		output.write("------------Choose one of the project-------------");
	}

	@Override
	public void printContent() {
		Category category = model.getCategory();
		System.out.println();
		for (int oneProject = 1; oneProject <= model.getProjectsList(category).size(); oneProject++) {
			output.write(oneProject + ". "
					+ model.getProjectsList(category).get(oneProject - 1).getName());
			output.write(model.getProjectsList(category).get(oneProject - 1).getShortContent());
		}
		output.write("\n0. Return");
	}

	@Override
	public State chooseDirection() {
		int inputNumber = input.readInt();
		if (inputNumber == 0) {
			state = State.CATEGORIES;
		} else if (inputNumber > 0
				&& inputNumber <= model.getProjectsList(model.getCategory()).size()) {
			state = State.PROJECT;
			setProject(inputNumber - 1);
		} else {
			state = State.ERROR_PROJECTS;
		}
		return state;
	}

	private void setProject(int inputNumber) {
		controller.setProject(model.getProjectsList(model.getCategory()).get(inputNumber));
	}
}