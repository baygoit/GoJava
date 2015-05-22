package kickstarter;

import java.io.IOException;

import kickstarter.interfaces.menu.CategoriesMenu;
import kickstarter.interfaces.menu.Menu;
import kickstarter.interfaces.menu.ProjectsMenu;
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
		viewMenu(CategoriesMenu.values());
	}

	private void viewMenu(Menu[] menu) {
		StringBuilder result = new StringBuilder();

		for (Menu item : menu) {
			result.append(item.getId());
			result.append(" - ");
			result.append(item);
		}

		view(result.toString());
	}

	public void viewProjects(String projects) {
		viewProjectsHead();
		view(projects);
		viewMenu(ProjectsMenu.values());
	}

	public void viewProject(String project) {
		viewProjectHead();
		view(project);
		viewMenu(ProjectsMenu.values());
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

	private void viewProjectsHead() {
		view("--------------------");
		view("Choice Project:");
	}

	private void viewProjectHead() {
		view("--------------------");
		view("Project:");
	}
}
