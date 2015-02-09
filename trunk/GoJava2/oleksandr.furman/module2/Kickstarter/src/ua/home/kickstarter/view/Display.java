package ua.home.kickstarter.view;

import java.util.List;
import java.util.Map;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.content.Project;
import ua.home.kickstarter.controller.CategoriesController;
import ua.home.kickstarter.controller.ProjectsController;
import ua.home.kickstarter.controller.QuotationsController;
import ua.home.kickstarter.model.ProjectStorage;

public class Display {

	private QuotationsController quotations;
	private CategoriesController categoriesController;
	private ProjectsController projects;
	private ConsoleOutput consoleOutput;
	private ProjectStorage projectStorage;

	public Display(QuotationsController quotations, CategoriesController categoriesController,
			ProjectsController projects, ConsoleOutput consoleOutput) {
		this.projectStorage = new ProjectStorage();
		this.consoleOutput = consoleOutput;
		this.quotations = quotations;
		this.categoriesController = categoriesController;
		this.projects = projects;
	}

	public void displayQuote() {
		consoleOutput.output(quotations.passRandomQuoteToView().getQuote());
	}

	public void displayCategories() {
		consoleOutput.output("Выберите категорию :");
		for (Map.Entry<Integer, Category> pair : categoriesController.passContentToView().entrySet()) {
			consoleOutput.output(pair.getKey() + " - " + pair.getValue().getName());
		}
		consoleOutput.output("[Выберите категорию от 1 до " + categoriesController.passContentToView().size()
				+ " или нажмите 0 для выхода из программы]\n ");
	}

	public void displaySelectedCategoryName(Category category) {

		consoleOutput.output("Вы выбрали категорию " + category.getName());
	}

	public void displayProjects(Category category) {

		int projectNumber = 1;
		for (Project project : projects.passSpecificContentToView(category)) {
			consoleOutput.output(projectNumber + project.getShortInfo());
			projectNumber++;
		}
		consoleOutput.output("[Выберите проект от 1 до " + projects.passSpecificContentToView(category).size()
				+ " или нажмите 0 для возврата к выбору категорий]\n ");
	}

	public void displaySpecificProject(int i, Category category) throws IndexOutOfBoundsException {

		List<Project> projects = projectStorage.getSpecificContent(category);

		consoleOutput.output(projects.get(i - 1).getFullInfo());
		consoleOutput.output("0 - возврат в категорию " + category.getName());
	}
}
