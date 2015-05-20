package kickstarter;

import java.io.IOException;
import java.util.Iterator;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.engine.Quote;
import kickstarter.interfaces.display.DisplayHandler;
import kickstarter.interfaces.printers.Printer;
import kickstarter.interfaces.readers.Reader;

public class View {

	private Printer printer;
	private Reader reader;
	private DisplayHandler display;

	public View(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
		this.display = new DisplayHandler();
	}

	private void view(String string) {
		printer.showMessage(string);
	}
	
	public void viewErrorMessage() {
		view("--------------------");
		view("try again please");
	}
	
	public void viewTheEndMessage() {
		view("---------");
		view("Good Luck!");
	}

	public void viewQuote(Quote quote) {
		printer.showMessage(display.getQuoteDisplay().getDescription(quote));
	}

	public void viewCategories(Iterator<Category> iterator) {
		printer.showMessage("--------------------");
		printer.showMessage("Choice Category:");
		
		//-----------------
		
		StringBuilder result = new StringBuilder();

		while (iterator.hasNext()) {
			result.append(display.getCategoryDisplay().getDescription(iterator.next()));
		}

		printer.showMessage(result.toString());
		
		//-----------
		viewCategoryMenu();
	}

	public void viewProjects(Iterator<Project> iterator) {
		printer.showMessage("--------------------");
		printer.showMessage("Choice Project:");

		//--
		
		StringBuilder result = new StringBuilder();

		while (iterator.hasNext()) {
			result.append(display.getProjectDisplay().getDescription(iterator.next()));
		}

		printer.showMessage(result.toString());
		
		//-----------
		viewProjectsMenu();
	}

	private void viewCategoryMenu() {
		StringBuilder menu = new StringBuilder();

		menu.append(Category.EXIT.getId());
		menu.append(" - ");
		menu.append(Category.EXIT.getName());

		printer.showMessage(menu.toString());

	}

	private void viewProjectsMenu() {
		StringBuilder menu = new StringBuilder();

		menu.append(Project.EXIT.getId());
		menu.append(" - ");
		menu.append(Project.EXIT.getName());

		printer.showMessage(menu.toString());

	}

	private void viewProjectMenu() {
		StringBuilder menu = new StringBuilder();

		menu.append(Project.EXIT.getId());
		menu.append(" - ");
		menu.append(Project.EXIT.getName());

		printer.showMessage(menu.toString());

	}

	public void viewProject(Project project) {
		view("--------------------");
		view("Project:");
		
		//-------------
		
		printer.showMessage(display.getProjectDetailDisplay().getDescription(project));
		
		//--------------
		
		viewProjectMenu();
	}

	public int choiceItem() throws NumberFormatException, IOException {
		return Integer.parseInt(reader.getLine());
	}
}
