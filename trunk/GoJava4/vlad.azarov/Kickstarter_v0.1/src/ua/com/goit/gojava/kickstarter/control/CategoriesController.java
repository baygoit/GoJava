package ua.com.goit.gojava.kickstarter.control;

import ua.com.goit.gojava.kickstarter.view.CategoriesViewer;
import ua.com.goit.gojava.kickstarter.view.ConsoleInputReader;
import ua.com.goit.gojava.kickstarter.view.Printer;

public class CategoriesController {

	private CategoriesViewer categoriesViewer;
	private ProjectsController projectsController;
	private ConsoleInputReader inputReader;
	private Printer printer;

	public CategoriesController(Printer printer) {
		categoriesViewer = new CategoriesViewer(printer);
		projectsController = new ProjectsController(printer);
		inputReader = new ConsoleInputReader();
		this.printer = printer;
	}

	public void callsShowCategoryMenu() {
		categoriesViewer.showCategoryMenu();		
	}
}
