package go_java_4.vadya_zakusylo.kickstarter;

import java.util.Set;

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
		output.write(quote.printQuote());
	}

	private void chooseCategory() {
		Set<Category> categories = content.categories.getCategories();
		while (true) {
			output.write("\nChoose the category:");
			int numberCategory = 0;
			for (Category category : categories) {
				System.out.println(++numberCategory + ". " + category.getNameCategory());
			}
			output.write("\nInput 0 for exit");
			output.write("\n--------------------------------------------------------------------------------");
			int index = inputIndex(categories);
			if (index == 0) {
				break;
			}
			/*category = categories;
			output.write("You chose " + category.getNameCategory());
			chooseProject();*/
		}
	}
/*
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
	}*/

	int inputIndex(Set<Category> categories) {
		int index = input.read();
		while (index < 0 || index > categories.size()) {
			output.write("Choose one of the variants!");
			index = input.read();
		}
		return index;
	}
}
