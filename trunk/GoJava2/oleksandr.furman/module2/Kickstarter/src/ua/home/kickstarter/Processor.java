package ua.home.kickstarter;

import java.util.InputMismatchException;
import java.util.Map;

public class Processor {
	private DataManager dataManager;
	private Categories categories;
	private Projects projects;
	private ConsoleInOut inOut;
	private OutputPreparer outputPreparer;
	private Category category;

	public void run() {
		dataManager = new DataManager();
		dataManager.storage();
		categories = dataManager.getCategories();
		projects = dataManager.getProjects();
		inOut = new ConsoleInOut();
		Quotations quotations = new Quotations();
		inOut.output(quotations.randomQuote());
		outputPreparer = new OutputPreparer(projects);
		categoriesPrint();
	}

	public void categoriesPrint() {
		try {
			inOut.output("");
			inOut.output("Выберите категорию:");
			for (Map.Entry<Integer, Category> pair : categories.getCategories().entrySet()) {
				inOut.output(pair.getKey() + " - " + pair.getValue().getName());
			}

			int categoryIndex = inOut.nextIntIndex();
			category = categories.getCategories().get(categoryIndex);
			inOut.output("Вы выбрали категорию " + category.getName());
			projectsPrint();
		} catch (IndexOutOfBoundsException e) {
			inOut.output("Введенный номер не соответствует ни одной категории(проекту), повторите ввод.");
		} catch (InputMismatchException e) {
			inOut.output("Введен некорректный символ, допустим ввод цифр от 0-9. Повторите ввод.");
		} catch (NullPointerException e) {
			inOut.output("Возможно выбранная Вами категория пустая, либо введен некорректный символ, повторите ввод.");
		}
	}

	public void projectsPrint() {
		for (String stringProjects : outputPreparer.stringProjectOutput(category)) {
			inOut.output(stringProjects);
		}

		int projectIndex = inOut.nextIntIndex();
		if (projectIndex == 0) {
			categoriesPrint();
		}

		for (String stringFullProject : outputPreparer.stringFullProjectOutput(projectIndex, category)) {
			inOut.output(stringFullProject);
		}
		if (inOut.nextIntIndex() == 0) {
			projectsPrint();
		}
	}
}
