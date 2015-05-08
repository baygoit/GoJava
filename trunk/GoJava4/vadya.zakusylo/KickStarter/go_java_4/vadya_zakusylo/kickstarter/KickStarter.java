package go_java_4.vadya_zakusylo.kickstarter;

import go_java_4.vadya_zakusylo.kickstarterPrinter.Printer;
import go_java_4.vadya_zakusylo.kickstarterRepository.ArrayCategory;
import go_java_4.vadya_zakusylo.kickstarterRepository.Category;
import go_java_4.vadya_zakusylo.kickstarterRepository.Content;
import go_java_4.vadya_zakusylo.kickstarterRepository.Project;
import go_java_4.vadya_zakusylo.kickstarterRepository.Quote;

import java.util.Scanner;

public class KickStarter {
	private Quote quote;
	private Content content;
	private Printer printer;

	public ArrayCategory arrayCategory = new ArrayCategory();
	public Category category;
	public Project project;

	public KickStarter(Quote quote, Content content, Printer printer) {
		this.quote = quote;
		this.content = content;
		this.printer = printer;
	}

	void go() {
		content.initContent();
		printQuote();
		chooseCategory();
		printer.println("Have a nice day!");
	}

	private void printQuote() {
		printer.println(quote.chooseQuote());
	}

	private void chooseCategory() {
		while (true) {
			Category[] categories = Content.arrayCategory.getCategories();
			printer.println("\nChoose the category:");
			for (int index = 0; index < categories.length; index++) {
				category = categories[index];
				printer.print(index + 1 + ". ");
				printer.println(category.getNameCategory());
			}
			printer.println("\nInput 0 for exit");
			int index = inputIndex(categories);
			if (index == 0) {
				break;
			}
			category = categories[index - 1];
			printer.println("You chose " + category.getNameCategory());
			chooseProject();
		}
	}

	private void chooseProject() {
		while (true) {
			Project[] projects = category.getProjects();
			printer.println("\nChoose the project:");
			for (int index = 0; index < projects.length; index++) {
				System.out.print(index + 1 + ". ");
				project = projects[index];
				printer.println(project.getName() + "\n\t" + project.getShortDescription()
						+ "\n\tNeed money: " + project.getNeedMoney() + "\tCurrent money: "
						+ project.getCurrentMoney() + "\n\tDays left: " + project.getDaysLeft());
			}
			printer.println("\nInput 0 for exit");
			int index = inputIndex(projects);
			if (index == 0) {
				break;
			}
			project = projects[index - 1];
			showProject();
		}
	}

	private void showProject() {
		while (true) {
			printer.println("You chose " + project.getName());
			printer.println("\nInput 0 for exit");
			@SuppressWarnings("resource")
			int index = new Scanner(System.in).nextInt();
			while (index != 0) {
				printer.println("Input 0 for exit");
				index = new Scanner(System.in).nextInt();
			}
			if (index == 0) {
				break;
			}
		}
	}

	@SuppressWarnings("resource")
	private int inputIndex(Object[] contents) {
		int index = new Scanner(System.in).nextInt();
		while (index < 0 || index > contents.length) {
			printer.println("Choose one of the variants!");
			index = new Scanner(System.in).nextInt();
		}
		return index;
	}
}
