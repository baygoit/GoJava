package ua.home.kickstarter.view;

import java.util.List;

import ua.home.kickstarter.model.Category;
import ua.home.kickstarter.model.Project;
import ua.home.kickstarter.model.Quote;

public class Display {

	private ConsoleOutput consoleOutput;

	public Display(ConsoleOutput consoleOutput) {
		this.consoleOutput = consoleOutput;
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

	public void displayProjects(List<Project> list) {
		StringBuilder displayProjects = new StringBuilder();
		int temporaryCounter = 1;
		for (Project project : list) {
			displayProjects.append(temporaryCounter).append(getShortInfo(project));
			temporaryCounter++;
		}
		displayProjects.append("[Выберите проект от 1 до ").append(list.size())
				.append(" или нажмите 0 для возврата к выбору категорий]\n");
		consoleOutput.output(displayProjects.toString());
	}

	public void displaySpecificProject(Project project) throws IndexOutOfBoundsException {
		StringBuilder displaySpecificProject = new StringBuilder();
		displaySpecificProject.append(getFullInfo(project)).append(
				"\n[1 - проинвестировать в проект, 0 - возврат к выбору проектов.]");
		consoleOutput.output(displaySpecificProject.toString());
	}

	public String getShortInfo(Project project) {
		StringBuilder shortInfo = new StringBuilder();
		shortInfo.append(" - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓").append("\nНазвание проекта: ")
				.append(project.getName()).append("\nОписание проекта: ").append(project.getDescription())
				.append("\nНеобходимая сумма: ").append(project.getGoal()).append("$").append("\nУже собрали: ")
				.append(project.getPledged()).append("$").append("\nДо окончания сбора средств: ")
				.append(project.getDaysLeft()).append(" дней\n");
		return shortInfo.toString();
	}

	public String getFullInfo(Project project) {
		StringBuilder fullInfo = new StringBuilder();
		fullInfo.append(getShortInfo(project)).append("История проекта: ").append(project.getHistory())
				.append("\nЛинки на видео с демо: ").append(project.getLinksToVideo()).append("\nВопросы/ответы: ")
				.append(project.getQuestionAnswers());
		return fullInfo.toString();
	}
}
