package ua.home.kickstarter.engine;

import ua.home.kickstarter.content.Project;
import ua.home.kickstarter.controller.CategoriesController;
import ua.home.kickstarter.controller.ProjectsController;
import ua.home.kickstarter.controller.QuotationsController;
import ua.home.kickstarter.view.ConsoleInput;
import ua.home.kickstarter.view.ConsoleOutput;
import ua.home.kickstarter.view.Display;

public class Kickstarter {
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
		if (input > 0 && input <= categoriesController.getCategoriesSizeToView()) {
			display.displaySelectedCategoryName(categoriesController.getDBCategoriesToView().get(input - 1).getName());
			menuLevel1(input);
		} else if (input == 0) {
			System.out.print("Спасибо за использование нашей программы!");
			return;
		} else {
			System.out.print("Категория под номером " + input + " отстствует в системе, повторите ввод. \n");
			menuLevel0();
		}
	}

	public void menuLevel1(int categoryId) {
		display.displayProjects(categoryId);
		menuLevel2(categoryId);
	}

	public void menuLevel2(int categoryId) {
		int input = -1;
		try {
			input = consoleInput.nextIntIndex();
			if (input > 0) {
				display.displaySpecificProject(categoryId, input);
				menuLevel3(categoryId, input);
			} else if (input == 0) {
				display.displayCategories();
				menuLevel0();
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.print("Проект под номером " + input + " отстствует в системе, повторите ввод. \n");
			menuLevel2(categoryId);
		}
	}

	public void menuLevel3(int categoryId, int index) {
		int input = consoleInput.nextIntIndex();
		if (input == 0) {
			menuLevel1(categoryId);
		} else if (input == 1) {
			System.out.print("Введите Ваше имя: ");
			consoleInput.nextString();
			System.out.print("Введите номер карты: ");
			consoleInput.nextString();
			System.out.print("Введите сумму платежа: ");
			int amount = consoleInput.nextIntIndex();
			Project project = projectsController.getSpecificProjectFromDB(categoryId, index);
			project.addPayment(amount);
			projectsController.updateProjectPledged(project.getId(), "pledged", project.getPledged());

			display.displaySpecificProject(categoryId, input);
			menuLevel3(categoryId, input);
		} else {
			menuLevel3(categoryId, input);
		}
	}
}
