package ua.home.kickstarter.view;

import java.util.List;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.content.Quote;
import ua.home.kickstarter.controller.ProjectsController;

public class Display {

	private ProjectsController projectsController;
	private ConsoleOutput consoleOutput;

	public Display(ProjectsController projectsController, ConsoleOutput consoleOutput) {
		this.consoleOutput = consoleOutput;
		this.projectsController = projectsController;
	}

	public void displayQuote(Quote quote) {
		consoleOutput.output(quote.getQuote());
	}

	public void displayCategories(List<Category> list) {
		StringBuilder displayCategories = new StringBuilder();
		displayCategories.append("Выберите категорию :\n");
		for (Category category : list) {
			displayCategories.append(category.getId()).append(" - ").append(category.getName()).append("\n");
		}
		displayCategories.append("[Выберите категорию от 1 до ").append(list.size())
				.append(" или нажмите 0 для выхода из программы]\n ");
		consoleOutput.output(displayCategories.toString());
	}

	public void displaySelectedCategoryName(String categoryName) {
		consoleOutput.output(new StringBuilder().append("Вы выбрали категорию ").append(categoryName).toString());
	}

	public void displayProjects(int categoryId) {
		StringBuilder displayProjects = new StringBuilder();
		displayProjects.append(projectsController.getProjectsContent(projectsController.getProjectsFromDB(categoryId)))
				.append("[Выберите проект от 1 до ").append(projectsController.getSpecificCategorySize(categoryId))
				.append(" или нажмите 0 для возврата к выбору категорий]\n");
		consoleOutput.output(displayProjects.toString());
	}

	public void displaySpecificProject(int categoryId, int index) throws IndexOutOfBoundsException {
		StringBuilder displaySpecificProject = new StringBuilder();
		displaySpecificProject.append(
				projectsController.getSpecificProjectContent(projectsController.getSpecificProjectFromDB(categoryId,
						index))).append("\n[1 - проинвестировать в проект, 0 - возврат к выбору проектов.]");
		consoleOutput.output(displaySpecificProject.toString());
	}
}
