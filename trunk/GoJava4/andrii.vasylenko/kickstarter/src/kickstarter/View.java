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
	
	public void view(String string) {
		printer.showMessage(string);
	}

	public void view(Quote quote) {
		printer.showMessage(display.getQuoteDisplay().getDescription(quote));
	}
	
	public void view(Iterator<Category> iterator) {
		StringBuilder result = new StringBuilder();

		while (iterator.hasNext()) {
			result.append(display.getCategoryDisplay().getDescription(iterator.next()));
		}
		
		printer.showMessage(result.toString());
	}
	
	public void viewP(Iterator<Project> iterator) {
		StringBuilder result = new StringBuilder();

		while (iterator.hasNext()) {
			result.append(display.getProjectDisplay().getDescription(iterator.next()));
		}
		
		printer.showMessage(result.toString());
	}
	
	public void viewCategoryMenu() {
		StringBuilder menu = new StringBuilder();
		
		menu.append(Category.EXIT.getId());
		menu.append(" - ");
		menu.append(Category.EXIT.getName());
		
		printer.showMessage(menu.toString());
		
	}
	
	public void viewProjectsMenu() {
		StringBuilder menu = new StringBuilder();
		
		menu.append(Project.EXIT.getId());
		menu.append(" - ");
		menu.append(Project.EXIT.getName());
		
		printer.showMessage(menu.toString());
		
	}
	
	public void viewProjectMenu() {
		StringBuilder menu = new StringBuilder();
		
		menu.append(Project.EXIT.getId());
		menu.append(" - ");
		menu.append(Project.EXIT.getName());
		
		printer.showMessage(menu.toString());
		
	}
	
	public void view(Project project) {
		printer.showMessage(display.getProjectDetailDisplay().getDescription(project));
	}
	
	public int choiceItem() throws NumberFormatException, IOException {
		return Integer.parseInt(reader.getLine());
	}
	
	/*public void choiceItem(ChoicePage page) {
		while (true) {
			try {
				int itemId = Integer.parseInt(reader.getLine());
				page.setChosenItem(itemId);
				return;
			} catch (Exception ignore) {
			}
			printer.showMessage("--------------------");
			printer.showMessage("try again please");
		}
	}*/
	

	/*private void showPage(Page page) {
		printer.showMessage(page.getHead());
		printer.showMessage(page.getBody());
	}*/
}
