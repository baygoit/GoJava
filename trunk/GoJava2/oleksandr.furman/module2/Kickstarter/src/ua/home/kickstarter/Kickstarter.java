package ua.home.kickstarter;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Kickstarter {

	private Categories categories;
	private Projects projects;

	public Kickstarter(Categories categories, Projects projects) {
		this.categories = categories;
		this.projects = projects;
	}

	public static void main(String[] args) {
		Category category1 = new Category("Games");
		Category category2 = new Category("Technology");
		Category category3 = new Category("Design");

		Categories categories = new Categories();

		categories.add(category1);
		categories.add(category2);
		categories.add(category3);

		Project project1 = new Project("Space Cadets: Away Missions", 40000, 28,
				"A cooperative game, the 3rd title in the Space Cadets line. "
						+ "Explore UFOs, acquire alien technology and fight hordes of hostile aliens!",
				"Тут будет история проекта №1", "Тут будут линки на видео и демо проекта №1");
		Project project2 = new Project("Epic PvP: Fantasy", 15000, 32,
				"Make a character by choosing a Class Deck, a Race Deck, "
						+ "and shuffling them together. Then battle in this fast-paced card game.",
				"Тут будет история проекта №2", "Тут будут линки на видео и демо проекта №2");
		Project project3 = new Project("BaneBeasts: Mighty Monsters", 11940, 17,
				"Grab the mightiest of monsters, from dragons and demons "
						+ "to rat beasts and orc wyverns, for your tabletop fantasy armies!",
				"Тут будет история проекта №3", "Тут будут линки на видео и демо проекта №3");

		Project project4 = new Project(
				"Flotilla for Raspberry Pi - Friendly Electronics",
				50000,
				21,
				"Build your next great idea in minutes, not hours. Hassle-free digital tinkering for everyone with Flotilla for Raspberry Pi!",
				"Тут будет история проекта №4", "Тут будут линки на видео и демо проекта №4");
		Project project5 = new Project(
				"Blynk - build an app for your Arduino project in 5 minutes",
				10000,
				35,
				"Platform with iOs and Android apps to control Arduino, Raspberry Pi and similar microcontroller boards over Internet.",
				"Тут будет история проекта №5", "Тут будут линки на видео и демо проекта №5");
		Project project6 = new Project(
				"A quality Dillenger folding electric bike for under $400.00!",
				30000,
				19,
				"Most reliable, easy to use, fun and affordable electric bike, ever! Available for delivery to anywhere in the world for under $400",
				"Тут будет история проекта №6", "Тут будут линки на видео и демо проекта №6");

		project1.setCategory(category1);
		project2.setCategory(category1);
		project3.setCategory(category1);
		project4.setCategory(category2);
		project5.setCategory(category2);
		project6.setCategory(category2);

		Projects projects = new Projects();
		projects.add(project1);
		projects.add(project2);
		projects.add(project3);
		projects.add(project4);
		projects.add(project5);
		projects.add(project6);

		Kickstarter kickstarter = new Kickstarter(categories, projects);
		kickstarter.run();
	}

	private void run() {
		Quotations quotations = new Quotations();
		System.out.println(quotations.nextQuote());
		while (true) {
			try {
				System.out.println();
				System.out.println("Выберите категорию:");
				for (Map.Entry<Integer, Category> pair : categories.getCategories().entrySet()) {
					System.out.println(pair.getKey() + " - " + pair.getValue().getName());
				}
				Scanner scanner = new Scanner(System.in);
				int categoryIndex = scanner.nextInt();
				Category category = categories.getName(categoryIndex);
				System.out.println("Вы выбрали категорию " + category.getName());
				while (true) {
					System.out.println();
					System.out.println("Выберите проект:");
					System.out.println("------------------------------------");
					List<Project> foundProjects = projects.getProjects(category);
					for (Project project : foundProjects) {
						System.out.println("Название проекта:           " + project.getName());
						System.out.println("Описание проекта:           " + project.getDescription());
						System.out.println("Необходимая сумма:          " + project.getGoal() + "$");
						System.out.println("Собранная сумма:            " + project.getPledged() + "$");
						System.out.println("До окончания сбора средств: " + project.getDaysLeft() + " дней");
						System.out.println("------------------------------------");
					}

					System.out.println("Введите 0 для выхода");
					System.out.println();

					int projectIndex = scanner.nextInt();
					if (projectIndex == 0)
						break;
					Project project = projects.getFullProject(projectIndex, category);
					System.out.println("Вы выбрали проект " + project.getName());
					System.out.println();
					System.out.println("Название проекта:           " + project.getName());
					System.out.println("Описание проекта:           " + project.getDescription());
					System.out.println("Необходимая сумма:          " + project.getGoal() + "$");
					System.out.println("Собранная сумма:            " + project.getPledged() + "$");
					System.out.println("До окончания сбора средств: " + project.getDaysLeft() + " дней");
					System.out.println("История проекта:            " + project.getHistory());
					System.out.println("Линки на видео с демо       " + project.getLinksToVideo());
					System.out.println("Вопросы/ответы:             " + project.getQuestions());
					System.out.println("------------------------------------");
					System.out.println("Введите 0 для выхода");
					int exit = scanner.nextInt();
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Введенный номер не соответствует ни одной категории(проекту), повторите ввод.");
			} catch (InputMismatchException e) {
				System.out.println("Введен некорректный символ, допустим ввод цифр от 0-9. Повторите ввод.");
			}
		}
	}
}