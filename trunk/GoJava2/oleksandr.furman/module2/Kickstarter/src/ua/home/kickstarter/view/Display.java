package ua.home.kickstarter.view;

import ua.home.kickstarter.controller.CategoriesController;
import ua.home.kickstarter.controller.ProjectsController;
import ua.home.kickstarter.controller.QuotationsController;

public class Display {

	private QuotationsController quotationsController;
	private CategoriesController categoriesController;
	private ProjectsController projectsController;
	private ConsoleOutput consoleOutput;

	public Display(QuotationsController quotations, CategoriesController categoriesController,
			ProjectsController projects, ConsoleOutput consoleOutput) {
		this.consoleOutput = consoleOutput;
		this.quotationsController = quotations;
		this.categoriesController = categoriesController;
		this.projectsController = projects;
	}

	public void displayQuote() {
		consoleOutput.output(quotationsController.getRandomQuoteToView());
	}

	public void displayCategories() {
		StringBuilder displayCategories = new StringBuilder();
		displayCategories.append("Выберите категорию :\n").append(categoriesController.getContent())
				.append("[Выберите категорию от 1 до *").append(" или нажмите 0 для выхода из программы]\n ");
		consoleOutput.output(displayCategories.toString());
	}

	public void displaySelectedCategoryName(String categoryName) {
		consoleOutput.output(new StringBuilder().append("Вы выбрали категорию ").append(categoryName).toString());
	}

	public void displayProjects(int categoryId) {
		StringBuilder displayProjects = new StringBuilder();
		displayProjects.append(projectsController.getContent(categoryId)).append(
				"[Выберите проект от 1 до * или нажмите 0 для возврата к выбору категорий]\n");
		consoleOutput.output(displayProjects.toString());
	}

	public void displaySpecificProject(int categoryId, int index) throws IndexOutOfBoundsException {
		StringBuilder displaySpecificProject = new StringBuilder();
		displaySpecificProject.append(projectsController.getSpecificProject(categoryId, index)).append(
				"\n[1 - проинвестировать в проект, 0 - возврат к выбору проектов.]");
		consoleOutput.output(displaySpecificProject.toString());
	}
}
