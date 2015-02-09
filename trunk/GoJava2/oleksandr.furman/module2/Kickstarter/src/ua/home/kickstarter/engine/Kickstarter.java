package ua.home.kickstarter.engine;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.controller.CategoriesController;
import ua.home.kickstarter.controller.ProjectsController;
import ua.home.kickstarter.controller.QuotationsController;
import ua.home.kickstarter.view.ConsoleInput;
import ua.home.kickstarter.view.ConsoleOutput;
import ua.home.kickstarter.view.Display;

public class Kickstarter {
	private Category category;
	private Display display;
	private ConsoleInput consoleInput;
	private ProjectsController projectsController;
	private CategoriesController categoriesController;

	public Kickstarter() {
		display = new Display(new QuotationsController(), categoriesController = new CategoriesController(),
				projectsController = new ProjectsController(), new ConsoleOutput());
		consoleInput = new ConsoleInput();
	}

	public void run() {
		display.displayQuote();
		display.displayCategories();
		menuLevel0();
	}

	public void menuLevel0() {
		int input = consoleInput.nextIntIndex();
		if (input > 0 && input <= projectsController.passContentToView().size()) {
			category = categoriesController.passSpecificContentToView(input);
			display.displaySelectedCategoryName(category);
			menuLevel1();
		} else {
			System.out.print("Категория под номером " + input + " отстствует в системе, повторите ввод. \n");
			menuLevel0();
		}
	}

	public void menuLevel1() {
		display.displayProjects(category);
		menuLevel2();
	}

	public void menuLevel2() {
		int input = 0;
		try {
			input = consoleInput.nextIntIndex();
			if (input > 0) {
				display.displaySpecificProject(input, category);
				menuLevel3();
			} else if (input == 0) {
				display.displayCategories();
				menuLevel0();
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.print("Проект под номером " + input + " отстствует в системе, повторите ввод. \n");
			menuLevel2();
		}
	}

	public void menuLevel3() {
		if (consoleInput.nextIntIndex() == 0) {
			menuLevel1();
		} else {
			menuLevel3();
		}
	}
}
