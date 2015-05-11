package go_java_4.vadya_zakusylo.kickstarter;

import go_java_4.vadya_zakusylo.kickstarter.input.Input;
import go_java_4.vadya_zakusylo.kickstarter.output.Output;
import go_java_4.vadya_zakusylo.kickstarter.repository.Category;
import go_java_4.vadya_zakusylo.kickstarter.repository.Content;
import go_java_4.vadya_zakusylo.kickstarter.repository.Project;
import go_java_4.vadya_zakusylo.kickstarter.repository.Quote;

public class KickStarter {
	private Quote quote;
	private Content content;
	private Output output;
	private Input input;

	private Category category;
	private Project project;

	public KickStarter(Quote quote, Content content, Output output, Input input) {
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
		output.write(quote.chooseQuote());
	}

	private void chooseCategory() {
		while (true) {
			Category[] categories = content.arrayCategory.getCategories();
			output.write("\nChoose the category:");
			showCategories(categories);
			output.write("\nInput 0 for exit");
			output.write("\n--------------------------------------------------------------------------------");
			int index = inputIndex(categories);
			if (index == 0) {
				break;
			}
			category = categories[index - 1];
			output.write("You chose " + category.getNameCategory());
			chooseProject();
		}
	}

	private void chooseProject() {
		while (true) {
			Project[] projects = category.getProjects();
			output.write("Choose the project:");
			showProjects(projects);
			output.write("\nInput 0 for exit");
			output.write("--------------------------------------------------------------------------------");
			int index = inputIndex(projects);
			if (index == 0) {
				break;
			}
			project = projects[index - 1];
			output.write("You chose " + project.getFullContent());
			showProject();
		}
	}

	private void showCategories(Category[] categories) {
		for (int indexCategory = 0; indexCategory < categories.length; indexCategory++) {
			category = categories[indexCategory];
			output.write(indexCategory + 1 + ". " + category.getNameCategory());
		}
	}

	private void showProjects(Project[] projects) {
		for (int indexProject = 0; indexProject < projects.length; indexProject++) {
			project = projects[indexProject];
			output.write(indexProject + 1 + ". " + project.getShortContent());
		}
	}

	private void showProject() {
		while (true) {
			output.write("\nInput 0 for exit");
			output.write("--------------------------------------------------------------------------------");
			int index = input.read();
			while (index != 0) {
				output.write("Input 0 for exit");
				index = input.read();
			}
			if (index == 0) {
				break;
			}
		}
	}

	private int inputIndex(Object[] contents) {
		int index = input.read();
		while (index < 0 || index > contents.length) {
			output.write("Choose one of the variants!");
			index = input.read();
		}
		return index;
	}
}
