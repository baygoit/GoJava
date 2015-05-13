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
	private ShowDataAgent dataViewGenerator;
	private Printer printer;
	private Reader reader;
	
	public UserInterface(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
		this.dataViewGenerator = new ShowDataAgent();
	}
	
	public void showQuotePage(Quote quote) {
		printer.showMessage(dataViewGenerator.getDescription(quote));
	}
	
	public Data choiceCategory(Storage<Category> storage) {
		return choiceItem("Choice Category:", storage);
	}

	public Data choiceProject(Storage<Project> storage) {
		return choiceItem("Choice Project:", storage);
	}

	public void showProject(Project project) {
		choiceItem(dataViewGenerator.getDetailedDescription(project), null);
	}

	public void showTheEndPage() {
		printer.showMessage("Good Luck!");
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
			printer.showMessage("try again please");
		}
	}

	private Data showChoiceItemDialog(String head, Storage<? extends Data> storage) throws NumberFormatException,
			IOException {
		int itemId = choiceItemId(head, dataViewGenerator.getItemsDescription(storage));
		if (itemId == Data.Defaults.EXIT.getId()) {
			return Data.Defaults.EXIT;
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
