package kickstarter;

import java.io.IOException;

import kickstarter.engine.Category;
import kickstarter.engine.Project;
import kickstarter.interfaces.printers.Printer;
import kickstarter.interfaces.readers.Reader;

public class View {

	private Printer printer;
	private Reader reader;

	public View(Printer printer, Reader reader) {
		this.printer = printer;
		this.reader = reader;
	}

	public void showQuoteDialog(String quote) {
		viewQuoteHead();
		view(quote);
	}

	public void viewCategories(String categories) {
		viewCategoriesHead();
		view(categories);
		viewCategoriesMenu();
	}

	public void viewProjects(String projects) {
		viewProjectsHead();
		view(projects);
		viewProjectsMenu();
	}

	public void viewProject(String project) {
		viewProjectHead();
		view(project);
		viewProjectMenu();
	}

	public void viewErrorMessage() {
		view("--------------------");
		view("try again please");
	}

	public void viewTheEndMessage() {
		view("---------");
		view("Good Luck!");
	}

	public int choiceItem() throws NumberFormatException, IOException {
		return Integer.parseInt(reader.getLine());
	}

	private void view(String string) {
		printer.showMessage(string);
	}

	private void viewQuoteHead() {
		view("Quote:");
	}
	
	private void viewCategoriesHead() {
		view("--------------------");
		view("Choice Category:");
	}

	private void viewCategoriesMenu() {
		StringBuilder menu = new StringBuilder();

		menu.append(Category.EXIT.getId());
		menu.append(" - ");
		menu.append(Category.EXIT.getName());

		view(menu.toString());
	}

	private void viewProjectsHead() {
		view("--------------------");
		view("Choice Project:");
	}

	private void viewProjectsMenu() {
		StringBuilder menu = new StringBuilder();

		menu.append(Project.EXIT.getId());
		menu.append(" - ");
		menu.append(Project.EXIT.getName());

		view(menu.toString());
	}

	private void viewProjectHead() {
		view("--------------------");
		view("Project:");
	}

	private void viewProjectMenu() {
		StringBuilder menu = new StringBuilder();

		menu.append(Project.EXIT.getId());
		menu.append(" - ");
		menu.append(Project.EXIT.getName());

		view(menu.toString());
	}
}
