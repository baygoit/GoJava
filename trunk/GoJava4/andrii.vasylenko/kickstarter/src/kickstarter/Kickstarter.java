package kickstarter;

import java.io.IOException;

import kickstarter.data_types.Category;
import kickstarter.data_types.Data;
import kickstarter.data_types.Project;
import kickstarter.data_types.Quote;
import kickstarter.interfaces.DataViewGenerator;
import kickstarter.interfaces.printers.Printer;
import kickstarter.interfaces.readers.Reader;
import kickstarter.storages.CategoriesStorage;
import kickstarter.storages.ProjectsStorage;
import kickstarter.storages.QuotesStorage;
import kickstarter.storages.Storage;

public class Kickstarter {

	private DataViewGenerator dataViewGenerator = new DataViewGenerator();
	private Printer printer;
	private Reader reader;
	private QuotesStorage quotesStorage;
	private CategoriesStorage categoriesStorage;
	private ProjectsStorage projectsStorage;

	public Kickstarter(Printer printer, Reader reader, QuotesStorage quotesStorage, CategoriesStorage categoriesStorage,
			ProjectsStorage projectsStorage) {
		this.printer = printer;
		this.reader = reader;
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
			Data item = choiceItem("Choice Category:", categoriesStorage);
			if (item == Data.Default.EXIT) {
				return;
			}
			Category category = (Category) item;
			choiceProject(category);
		}
	}

	private void choiceProject(Category category) {
		while (true) {
			Data item = choiceItem("Choice Project:", projectsStorage.getProjectsInCategory(category));
			if (item == Data.Default.EXIT) {
				return;
			}
			Project project = (Project) item;
			showItem(dataViewGenerator.getDetailedDescription(project));
		}
	}


	public Data showItem(String item) {
		return choiceItem(item, null);
	}


	public Data choiceItem(String message, Storage<? extends Data> storage) {
		while (true) {
			try {
				return showChoiceItemDialog(message, storage);
			} catch (IndexOutOfBoundsException ignore) {
			} catch (NumberFormatException ignore) {
			} catch (IOException ignore) {
			}
			printer.showMessage("--------------------");
			printer.showMessage("try again please");
		}
	}

	private Data showChoiceItemDialog(String message, Storage<? extends Data> storage) throws NumberFormatException, IOException {
		int itemId = choiceItemId(message, dataViewGenerator.getItemsDescription(storage));
		if (itemId == Data.Default.EXIT.getId()) {
			return Data.Default.EXIT;
		}
		return getItemById(itemId, storage);
	}

	private Data getItemById(int id, Storage<? extends Data> storage) {
		if (storage == null) {
			throw new IndexOutOfBoundsException();
		}
		Data result = storage.getById(id);
		return result;
	}

	private int choiceItemId(String message, String items) throws NumberFormatException, IOException {
		printer.showMessage("--------------------");
		printer.showMessage(message);
		printer.showMessage(items);
		return Integer.parseInt(reader.getLine());
	}
}
