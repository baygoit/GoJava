package ua.home.kickstarter.view;

import java.util.List;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.content.Project;
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
		displayCategories.append("Выберите категорию :\n").append(categoriesController.passContentToView()).append("[Выберите категорию от 1 до ")
		.append(categoriesController.passCategoriesSizeToView()).append(" или нажмите 0 для выхода из программы]\n ");
		consoleOutput.output(displayCategories.toString());			
	}

	public void displaySelectedCategoryName(Category category) {
		consoleOutput.output("Вы выбрали категорию " + category.getName());
	}

	public void displayProjects(Category category) {

		int projectNumber = 1;
		for (Project project : projectsController.passSpecificContentToView(category)) {
			consoleOutput.output(projectNumber + project.getShortInfo());
			projectNumber++;
		}
		consoleOutput.output("[Выберите проект от 1 до "
				+ projectsController.passSpecificContentToView(category).size()
				+ " или нажмите 0 для возврата к выбору категорий]\n ");
	}

	public void displaySpecificProject(int i, Category category) throws IndexOutOfBoundsException {
		List<Project> projects = projectsController.passSpecificContentToView(category);
		consoleOutput.output(projects.get(i - 1).getFullInfo());
		consoleOutput.output("0 - возврат в категорию " + category.getName());
	}
}
