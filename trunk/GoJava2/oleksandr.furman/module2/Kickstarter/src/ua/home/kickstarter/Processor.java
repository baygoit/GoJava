package ua.home.kickstarter;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class Processor {
	private Categories categories;
	private Projects projects;

	public Processor(Categories categories, Projects projects) {
		this.categories = categories;
		this.projects = projects;
	}
	public void run() {
		InOut inOut = new InOut();
		Quotations quotations = new Quotations();
		inOut.output(quotations.nextQuote());

		while (true) {
			try {
				inOut.output("");
				inOut.output("Выберите категорию:");
				for (Map.Entry<Integer, Category> pair : categories.getCategories().entrySet()) {
					inOut.output(pair.getKey() + " - " + pair.getValue().getName());
				}

				int categoryIndex = inOut.input();
				Category category = categories.getName(categoryIndex);
				inOut.output("Вы выбрали категорию " + category.getName());
				while (true) {
					inOut.output("");
					inOut.output("Выберите проект:");
					inOut.output("------------------------------------");
					List<Project> foundProjects = projects.getProjects(category);
					for (Project project : foundProjects) {
						inOut.output("Название проекта:           " + project.getName());
						inOut.output("Описание проекта:           " + project.getDescription());
						inOut.output("Необходимая сумма:          " + project.getGoal() + "$");
						inOut.output("Собранная сумма:            " + project.getPledged() + "$");
						inOut.output("До окончания сбора средств: " + project.getDaysLeft() + " дней");
						inOut.output("------------------------------------");
					}

					inOut.output("Введите 0 для выхода");
					inOut.output("");

					int projectIndex = inOut.input();
					if (projectIndex == 0)
						break;
					Project project = projects.getFullProject(projectIndex, category);
					inOut.output("Вы выбрали проект " + project.getName());
					inOut.output("");
					inOut.output("Название проекта:           " + project.getName());
					inOut.output("Описание проекта:           " + project.getDescription());
					inOut.output("Необходимая сумма:          " + project.getGoal() + "$");
					inOut.output("Собранная сумма:            " + project.getPledged() + "$");
					inOut.output("До окончания сбора средств: " + project.getDaysLeft() + " дней");
					inOut.output("История проекта:            " + project.getHistory());
					inOut.output("Линки на видео с демо       " + project.getLinksToVideo());
					inOut.output("Вопросы/ответы:             " + project.getQuestions());
					inOut.output("------------------------------------");
					inOut.output("Введите 0 для выхода");
					int exit = inOut.input();
				}
			} catch (IndexOutOfBoundsException e) {
				inOut.output("Введенный номер не соответствует ни одной категории(проекту), повторите ввод.");
			} catch (InputMismatchException e) {
				inOut.output("Введен некорректный символ, допустим ввод цифр от 0-9. Повторите ввод.");
			}
		}
	}
}
