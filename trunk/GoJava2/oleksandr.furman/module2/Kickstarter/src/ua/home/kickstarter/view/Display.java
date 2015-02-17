package ua.home.kickstarter.view;

import ua.home.kickstarter.content.Category;
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
		consoleOutput.output(quotationsController.getRandomQuoteToView().getQuote());
	}

	public void displayCategories() {
		StringBuilder displayCategories = new StringBuilder();
		displayCategories.append("Выберите категорию :\n").append(categoriesController.getContentToView())
				.append("[Выберите категорию от 1 до ").append(categoriesController.getCategoriesSizeToView())
				.append(" или нажмите 0 для выхода из программы]\n ");
		consoleOutput.output(displayCategories.toString());
	}

	public void displaySelectedCategoryName(Category category) {
		consoleOutput.output(new StringBuilder().append("Вы выбрали категорию ").append(category.getName()).toString());
	}

	public void displayProjects(Category category) {
		StringBuilder displayProjects = new StringBuilder();
		displayProjects.append(projectsController.getSpecificContentToView(category))
				.append("[Выберите проект от 1 до ").append(projectsController.getSpecificCategorySize(category))
				.append(" или нажмите 0 для возврата к выбору категорий]\n ");
		consoleOutput.output(displayProjects.toString());
	}

	public void displaySpecificProject(int i, Category category) throws IndexOutOfBoundsException {
		StringBuilder displaySpecificProject = new StringBuilder();
		displaySpecificProject.append(projectsController.getSpecificProjectToView(i, category))
				.append("\n0 - возврат в категорию ").append(category.getName())
				.append(", 1 - проинвестировать в проект");
		consoleOutput.output(displaySpecificProject.toString());
	}
}
