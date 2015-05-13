package kickstarter.interfaces;

import kickstarter.engine.Category;
import kickstarter.engine.Data;
import kickstarter.engine.Project;
import kickstarter.engine.Quote;
import kickstarter.interfaces.display.CategoryDisplay;
import kickstarter.interfaces.display.DisplayHalper;
import kickstarter.interfaces.display.ProjectDisplay;
import kickstarter.interfaces.display.QuoteDisplay;
import kickstarter.interfaces.printers.Printer;
import kickstarter.interfaces.readers.Reader;
import kickstarter.storages.Storage;

public class UserInterface {
	private Printer printer;
	private Reader reader;

	public UserInterface(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
	}

	public void showQuotePage(Quote quote) {
		QuoteDisplay display = new QuoteDisplay();
		printer.showMessage(display.getDescription(quote));
	}

	public Data choiceCategory(Storage<Category> storage) {
		CategoryDisplay display = new CategoryDisplay();
		String head = "Choice Category:";
		return new DisplayHalper<Category>(printer, reader, display, storage).choiceItem(head);
	}

	public Data choiceProject(Storage<Project> storage) {
		ProjectDisplay display = new ProjectDisplay();
		String head = "Choice Project:";
		return new DisplayHalper<Project>(printer, reader, display, storage).choiceItem(head);
	}

	public void showProject(Project project) {
		ProjectDisplay display = new ProjectDisplay();
		String head = display.getDetailedDescription(project);
		new DisplayHalper<Project>(printer, reader, display).choiceItem(head);
	}

	public void showTheEndPage() {
		printer.showMessage("Good Luck!");
	}
}
