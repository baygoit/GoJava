package ua.goit.goitjava.kickstarter.DB;

import java.util.List;

import ua.goit.goitjava.kickstarter.Category;
import ua.goit.goitjava.kickstarter.Quote;

public class View {

	public void printSelectProject(Project project) {
		System.out.println(project.getName() + "\n " + project.getDescription()
				+ "\n We need - " + project.getNeedMoney() + "$\n We have - "
				+ project.getHaveMoney() + "$\n Time over - "
				+ project.getDaysBeforeEnd() + " days"
				+ project.getProjectHistory() + "\n "
				+ project.getLinkToDemoVideo());
	}

	public void printProject(List<Project> list) {
		int i = 0;
		for (Project project : list) {
			i++;
			System.out.println(i + ") " + project.getName() + "\n "
					+ project.getDescription() + "\n We need - "
					+ project.getNeedMoney() + "$\n We have - "
					+ project.getHaveMoney() + "$\n Time over - "
					+ project.getDaysBeforeEnd() + " days");
		}

	}

	public void printQuote() {
		Quote quote = new Quote();
		System.out.println(quote.getLaoTzu());
	}

	public void printAllCategories(List<Category> list) {
		for (Category cat : list) {
			System.out.println(cat.getId() + " " + cat.getName());
		}
	}

	public void printSelectCategory(Category category) {
		System.out.println(category.getName());
	}

	public void showZero() {
		System.out.println("0) Back one step");
	}
}
