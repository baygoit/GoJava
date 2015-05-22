package org.dens.kikstarter.face;

import java.util.List;

import org.dens.kikstarter.data.Category;
import org.dens.kikstarter.data.CategoryProducer;
import org.dens.kikstarter.data.CitationProducer;

public class CategoryView implements View {

	private CategoryProducer producer = new CategoryProducer();
	private ConsoleScanner scanner = new ConsoleScanner();

	@Override
	public void printInfo() {
		List<Category> categories = producer.getCategories();
		for (int index = 0; index < categories.size(); index++) {
			scanner.printOption(index + 1, categories.get(index).getName());
		}
	}

	@Override
	public void action(ViewState viewState) {
		// 1. choose category
		// 2. print chosen category details or error
		// 3. step into Projects view if category is choosen
		scanner.printLine("Select Category by ID:", false);
		String indexString = scanner.read();
		int input;
		Category category;
		try {
			input = parseInput(indexString);
			category = producer.getCategories().get(input);
			scanner.printHeader(category.getName());
			scanner.printLine(category.getDescription(), false);
			ProjectsView projectsView = new ProjectsView(category);
			viewState.setView(projectsView);
		} catch (Exception ex) {
			scanner.printLine("Incorrect input: " + indexString, false);
		}
	}

	private int parseInput(String input) {
		return Integer.valueOf(input);
	}

}
