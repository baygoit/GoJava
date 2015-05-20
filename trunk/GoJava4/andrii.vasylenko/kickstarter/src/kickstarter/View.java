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

	public void viewQuote(Quote quote) {
		view(display.getQuoteDisplay().getDescription(quote));
	}

	public void viewCategories(Iterator<Category> iterator) {
		viewCategoriesHead();
		viewCategoriesBody(iterator);
		viewCategoriesMenu();
	}

	public void viewProjects(Iterator<Project> iterator) {
		viewProjectsHead();
		viewProjectsBody(iterator);
		viewProjectsMenu();
	}

	public void viewProject(Project project) {
		viewProjectHead();
		view(display.getProjectDetailDisplay().getDescription(project));
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

	private void viewCategoriesHead() {
		view("--------------------");
		view("Choice Category:");
	}

	private void viewCategoriesBody(Iterator<Category> iterator) {
		StringBuilder result = new StringBuilder();

		while (iterator.hasNext()) {
			result.append(display.getCategoryDisplay().getDescription(iterator.next()));
		}

		view(result.toString());
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

	private void viewProjectsBody(Iterator<Project> iterator) {
		StringBuilder result = new StringBuilder();

		while (iterator.hasNext()) {
			result.append(display.getProjectDisplay().getDescription(iterator.next()));
		}

		view(result.toString());
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
