package kickstarter;

import kickstarter.data_types.Category;
import kickstarter.data_types.Data;
import kickstarter.data_types.Project;
import kickstarter.data_types.Quote;
import kickstarter.interfaces.Printer;
import kickstarter.interfaces.DataViewGenerator;
import kickstarter.storages.CategoriesStorage;
import kickstarter.storages.ProjectsStorage;
import kickstarter.storages.QuotesStorage;

public class Kickstarter {

	private DataViewGenerator dataViewGenerator;
	private Printer printer;
	private QuotesStorage quotesStorage;
	private CategoriesStorage categoriesStorage;
	private ProjectsStorage projectsStorage;

	public Kickstarter(DataViewGenerator view, Printer printer, QuotesStorage quotesStorage, CategoriesStorage categoriesStorage,
			ProjectsStorage projectsStorage) {
		this.dataViewGenerator = view;
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
		printer.showMessage(dataViewGenerator.getDescription(randomQuote));
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
			printer.showItem(dataViewGenerator.getDetailedDescription(project));
		}
	}

}
