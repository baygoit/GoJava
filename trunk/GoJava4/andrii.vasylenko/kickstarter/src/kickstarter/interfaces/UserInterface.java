package kickstarter.interfaces;

import java.io.IOException;

import kickstarter.data_types.Category;
import kickstarter.data_types.Data;
import kickstarter.data_types.Project;
import kickstarter.data_types.Quote;
import kickstarter.interfaces.printers.Printer;
import kickstarter.interfaces.readers.Reader;
import kickstarter.storages.Storage;

public class UserInterface {
	private DataViewGenerator dataViewGenerator = new DataViewGenerator();
	private Printer printer;
	private Reader reader;
	
	public UserInterface(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
	}
	
	public void showTheEndPage() {
		printer.showMessage(dataViewGenerator.getTheEndPageHead());
	}

	public void showQuotePage(Quote quote) {
		printer.showMessage(dataViewGenerator.getDescription(quote));
	}
	
	public Data choiceCategory(Storage<Category> storage) {
		return choiceItem(dataViewGenerator.getCategoryPageHead(), storage);
	}

	public Data choiceProject(Storage<Project> storage) {
		return choiceItem(dataViewGenerator.getProjectPageHead(), storage);
	}

	public void showProject(Project project) {
		choiceItem(dataViewGenerator.getDetailedDescription(project), null);
	}

	private Data choiceItem(String head, Storage<? extends Data> storage) {
		while (true) {
			try {
				return showChoiceItemDialog(head, storage);
			} catch (IndexOutOfBoundsException ignore) {
			} catch (NumberFormatException ignore) {
			} catch (IOException ignore) {
			}
			printer.showMessage("--------------------");
			printer.showMessage(dataViewGenerator.getErrorMessage());
		}
	}

	private Data showChoiceItemDialog(String head, Storage<? extends Data> storage) throws NumberFormatException,
			IOException {
		int itemId = choiceItemId(head, dataViewGenerator.getItemsDescription(storage));
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

	private int choiceItemId(String head, String items) throws NumberFormatException, IOException {
		printer.showMessage("--------------------");
		printer.showMessage(head);
		printer.showMessage(items);
		return Integer.parseInt(reader.getLine());
	}
}
