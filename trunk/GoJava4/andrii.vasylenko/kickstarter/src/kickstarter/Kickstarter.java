package kickstarter;

import interfaces.Printer;
import data_types.Category;
import data_types.Data;
import data_types.Project;
import data_types.Quote;
import storages.CategoriesStorage;
import storages.ProjectsStorage;
import storages.QuotesStorage;

public class Kickstarter {

	private Printer printer;
	private QuotesStorage quotesStorage;
	private CategoriesStorage categoriesStorage;
	private ProjectsStorage projectsStorage;

	public Kickstarter(Printer printer, QuotesStorage quotesStorage, CategoriesStorage categoriesStorage,
			ProjectsStorage projectsStorage) {
		this.printer = printer;
		this.quotesStorage = quotesStorage;
		this.categoriesStorage = categoriesStorage;
		this.projectsStorage = projectsStorage;
	}

	public void run() {
		showQuote();
		choiceCategory();
		printer.showMessage("Good Luck!");
	}

	private void showQuote() {
		if (quotesStorage.empty()) {
			return;
		}
		Quote randomQuote = quotesStorage.getRandom();
		printer.showMessage(randomQuote.toString());
	}

	private void choiceCategory() {
		while (true) {
			Data item = printer.choiceItem("Choice Category:", categoriesStorage);
			if (item == Data.Default.EXIT) {
				return;
			}
			Category category = (Category) item;
			choiceProject(category);
		}
	}

	private void choiceProject(Category category) {
		while (true) {
			Data item = printer.choiceItem("Choice Project:", projectsStorage.getProjectsInCategory(category));
			if (item == Data.Default.EXIT) {
				return;
			}
			Project project = (Project) item;
			printer.showItem(project.getDetailedDescription());
		}
	}

}
