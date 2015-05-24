package go_java_4.vadya_zakusylo.kickstarter;

import go_java_4.vadya_zakusylo.kickstarter.input.Input;
import go_java_4.vadya_zakusylo.kickstarter.output.Output;
import go_java_4.vadya_zakusylo.kickstarter.repository.CategoryInterface;
import go_java_4.vadya_zakusylo.kickstarter.repository.ContentInterface;
import go_java_4.vadya_zakusylo.kickstarter.repository.ProjectInterface;
import go_java_4.vadya_zakusylo.kickstarter.repository.QuoteInterface;

import java.util.List;

public class KickStarter {
	private QuoteInterface quote;
	private ContentInterface content;
	private Output output;
	private Input input;

	private CategoryInterface category;
	private ProjectInterface project;

	public KickStarter(QuoteInterface quote, ContentInterface content, Output output, Input input) {
		this.quote = quote;
		this.content = content;
		this.output = output;
		this.input = input;
	}

	void go() {
		printQuote();
		chooseCategory();
		output.write("Have a nice day!");
	}

	private void printQuote() {
		output.write(quote.printQuote());
	}

	private void chooseCategory() {
		List<CategoryInterface> categories = content.getCategories();
		while (true) {
			if (categories.isEmpty()) {
				output.write("Kickstarter is empty!");
			} else {
				output.write("Choose the category:");
			}
			showCategories(categories);
			int indexCategories = inputIndex(categories);
			if (indexCategories == 0) {
				output.write("--------------------------------------------------------------------------------");
				break;
			}
			category = categories.get(indexCategories - 1);
			output.write("--------------------------------------------------------------------------------");
			output.write("You chose " + category.getName());
			chooseProject();
		}
	}

	private void chooseProject() {
		List<ProjectInterface> projects = category.getProjects();
		while (true) {
			if (projects.isEmpty()) {
				output.write("Category is empty!");
			} else {
				output.write("Choose the project:");
			}
			showProjects(projects);
			int indexProjects = inputIndex(projects);
			if (indexProjects == 0) {
				output.write("--------------------------------------------------------------------------------");
				break;
			}
			project = projects.get(indexProjects - 1);
			output.write("--------------------------------------------------------------------------------");
			output.write("You chose " + project.getFullContent());
			exitFromProject();
		}
	}

	private void exitFromProject() {
		while (true) {
			output.write("\nInput 0 for exit");
			output.write("--------------------------------------------------------------------------------");
			int exitIndex = input.read();
			while (exitIndex != 0) {
				output.write("Input 0 for exit");
				output.write("--------------------------------------------------------------------------------");
				exitIndex = input.read();
			}
			if (exitIndex == 0) {
				output.write("--------------------------------------------------------------------------------");
				break;
			}
		}
	}

	private void showCategories(List<CategoryInterface> categories) {
		for (int indexCategory = 0; indexCategory < categories.size(); indexCategory++) {
			category = categories.get(indexCategory);
			output.write(indexCategory + 1 + ". " + category.getName());
		}
		output.write("\nInput 0 for exit");
		output.write("--------------------------------------------------------------------------------");
	}

	private void showProjects(List<ProjectInterface> projects) {
		for (int indexProject = 0; indexProject < projects.size(); indexProject++) {
			project = projects.get(indexProject);
			output.write(indexProject + 1 + ". " + project.getShortContent());
		}
		output.write("\nInput 0 for exit");
		output.write("--------------------------------------------------------------------------------");
	}

	int inputIndex(List<?> content) {
		int index = input.read();
		while (index < 0 || index > content.size()) {
			output.write("Choose one of the variants!");
			output.write("--------------------------------------------------------------------------------");
			index = input.read();
		}
		return index;
	}

}
