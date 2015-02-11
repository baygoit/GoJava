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
		consoleOutput.output(quotationsController.passRandomQuoteToView().getQuote());
	}
 
	public void displayCategories() {
		StringBuilder displayCategories = new StringBuilder();
		displayCategories.append("Выберите категорию :\n").append(categoriesController.passContentToView())
				.append("[Выберите категорию от 1 до ").append(categoriesController.passCategoriesSizeToView())
				.append(" или нажмите 0 для выхода из программы]\n ");
		consoleOutput.output(displayCategories.toString());
	}

	public void displaySelectedCategoryName(Category category) {
		consoleOutput.output("Вы выбрали категорию " + category.getName());
	}

	public void displayProjects(Category category) {
		StringBuilder displayProjects = new StringBuilder();
		displayProjects.append(projectsController.passSpecificContentToView(category))
				.append("[Выберите проект от 1 до ").append(projectsController.passSpecificCategorySize(category))
				.append(" или нажмите 0 для возврата к выбору категорий]\n ");
		consoleOutput.output(displayProjects.toString());
	}

	public void displaySpecificProject(int i, Category category) throws IndexOutOfBoundsException {
		StringBuilder displaySpecificProject = new StringBuilder();
		displaySpecificProject.append(projectsController.passSpecificProjectToView(i, category))
				.append("\n0 - возврат в категорию ").append(category.getName());
		consoleOutput.output(displaySpecificProject.toString());
	}
}
