package goit.nz.kickstartermvc.view;

import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.model.CategoryModel;
import goit.nz.kickstartermvc.output.Output;

public class CategoryView {

	private Output output;

	public CategoryView(Output output) {
		this.output = output;
	}

	public void printProjects(CategoryModel model, String categoryName) {
		int modelSize = model.size();
		if (modelSize > 0) {
			printTitle(categoryName);
			int index = 0;
			for (Project project : model.getProjects()) {
				printProjectInfo(index++, project);
			}
		} else {
			printNotFound(categoryName);
		}
		printOptions(modelSize);
	}

	public void showMsg(String msg) {
		output.println("");
		output.println(msg);
	}

	private void printProjectInfo(int index, Project project) {
		output.println(String.format("(%d). %s", index + 1, project.getName()));
		output.println(String.format("     Description: %s",
				project.getDescription()));
		output.println(String.format("     Goal: %s", project.getGoalAmount()));
		output.println(String.format("     Pledged: %s",
				project.getPledgedAmount()));
		output.println(String.format("     Days to go: %s",
				project.getDaysToGo()));
	}

	private void printTitle(String categoryName) {
		output.println("");
		output.println(String.format("Projects in category: \"%s\"",
				categoryName.toUpperCase()));
		output.println("-------------------");
	}

	private void printOptions(int size) {
		output.println("");
		if (size > 0) {
			output.println(String.format(
					"Choose your option [1 - %d] (0 - back)", size));
		} else {
			output.println("(0 - back)");
		}
	}

	private void printNotFound(String categoryName) {
		output.println("");
		output.println(String.format(
				"There are no projects of category \"%s\"", categoryName.toUpperCase()));
	}
}
