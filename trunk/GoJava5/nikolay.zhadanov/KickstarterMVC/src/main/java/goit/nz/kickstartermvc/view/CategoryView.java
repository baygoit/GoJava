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
		output.write("");
		output.write(msg);
	}

	private void printProjectInfo(int index, Project project) {
		output.write(String.format("(%d). %s", index + 1, project.getName()));
		output.write(String.format("     Description: %s",
				project.getDescription()));
		output.write(String.format("     Goal: %d", project.getGoalAmount()));
		output.write(String.format("     Pledged: %d",
				project.getPledgedAmount()));
		output.write(String.format("     Days to go: %d",
				project.getDaysToGo()));
	}

	private void printTitle(String categoryName) {
		output.write("");
		output.write(String.format("Projects in category: \"%s\"",
				categoryName.toUpperCase()));
		output.write("-------------------");
	}

	private void printOptions(int size) {
		output.write("");
		if (size > 0) {
			output.write(String.format(
					"Choose your option [1 - %d] (0 - back)", size));
		} else {
			output.write("(0 - back)");
		}
	}

	private void printNotFound(String categoryName) {
		output.write("");
		output.write(String.format(
				"There are no projects of category \"%s\"", categoryName.toUpperCase()));
	}
}
