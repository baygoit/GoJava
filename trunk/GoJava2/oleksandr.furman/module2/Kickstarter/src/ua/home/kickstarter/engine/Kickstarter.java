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
	private ConsoleOutput consoleOutput;
	private Project project;

	public Kickstarter(QuotationsController quotationsController, CategoriesController categoriesController,
			ProjectsController projectsController, ConsoleOutput consoleOutput, ConsoleInput consoleInput,
			Display display) {
		this.categoriesController = categoriesController;
		this.projectsController = projectsController;
		this.consoleOutput = consoleOutput;
		this.consoleInput = consoleInput;
		this.display = display;
	}

	public void run() {
		display.displayQuote();
		display.displayCategories();
		menuLevel0();
	}

	public void menuLevel0() {
		int input = consoleInput.nextIntIndex();
		if (input > 0 && input <= categoriesController.getCategoriesSize()) {
			display.displaySelectedCategoryName(categoriesController.getCategoriesFromDB().get(input - 1).getName());
			menuLevel1(input);
		} else if (input == 0) {
			consoleOutput.output("Спасибо за использование нашей программы!");
			return;
		} else {
			consoleOutput.output("Категория под номером " + input + " отстствует в системе, повторите ввод. \n");
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
				project = projectsController.getProjectsFromDB(categoryId).get(input - 1);
				display.displaySpecificProject(categoryId, project.getId());
				menuLevel3(categoryId, input);
			} else if (input == 0) {
				display.displayCategories();
				menuLevel0();
			}
		} catch (IndexOutOfBoundsException e) {
			consoleOutput.output("Проект под номером " + input + " отстствует в системе, повторите ввод. \n");
			menuLevel2(categoryId);
		}
	}

	public void menuLevel3(int categoryId, int index) {
		int input = consoleInput.nextIntIndex();
		if (input == 0) {
			menuLevel1(categoryId);
		} else if (input == 1) {
			consoleOutput.output("Введите Ваше имя: ");
			consoleInput.nextString();
			consoleOutput.output("Введите номер карты: ");
			consoleInput.nextString();
			consoleOutput.output("Введите сумму платежа: ");
			int amount = consoleInput.nextIntIndex();

			project.addPayment(amount);
			projectsController.updateProject(project.getId(), "pledged", project.getPledged());

			display.displaySpecificProject(categoryId, project.getId());
			menuLevel3(categoryId, index);
		} else {
			menuLevel3(categoryId, index);
		}
	}
}
