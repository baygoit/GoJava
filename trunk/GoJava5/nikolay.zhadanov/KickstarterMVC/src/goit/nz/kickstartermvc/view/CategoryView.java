package goit.nz.kickstartermvc.view;

import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.model.CategoryModel;
import goit.nz.kickstartermvc.output.Output;

public class CategoryView {

	private Output output;

	public CategoryView(Output output) {
		this.output = output;
	}

	public void printProjects(CategoryModel model) {
		int modelSize = model.size();
		String categoryName = model.getCategoryName().toUpperCase();
		if (modelSize > 0) {
			printTitle(categoryName);
			int index = 0;
			for (Project project : model.getProjects()) {
				printProjectInfo(index, project);
				index++;
			}
			printOptions(modelSize);
		} else {
			printNotFound(categoryName);
		}
	}

	public void showMsg(String msg) {
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
				categoryName));
		output.println("-------------------");
	}

	private void printOptions(int size) {
		output.println("");
		output.println(String.format("Choose your option [1 - %d] (0 - back)",
				size));
	}

	private void printNotFound(String categoryName) {
		output.println("");
		output.println(String.format(
				"There are no projects of category \"%s\"", categoryName));
		output.println("");
		output.println("(0 - back)");
	}
}
