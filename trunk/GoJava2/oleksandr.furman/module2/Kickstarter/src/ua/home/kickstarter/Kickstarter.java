package ua.home.kickstarter;

import java.util.Arrays;
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

		
		Project project1 = new Project("Space Cadets: Away Missions", 40000, 28, "A cooperative game, the 3rd title in the Space Cadets line. Explore UFOs, acquire alien technology and fight hordes of hostile aliens!", "Тут будуистория проекта №1", "Тут будут линки на видео и демо проекта №1");
		Project project2 = new Project("Epic PvP: Fantasy", 15000, 32, "Make a character by choosing a Class Deck, a Race Deck, and shuffling them together. Then battle in this fast-paced card game.", "Тут будуистория проекта №2", "Тут будут линки на видео и демо проекта №2");
		Project project3 = new Project("BaneBeasts: Mighty Monsters", 11940, 17, "Grab the mightiest of monsters, from dragons and demons to rat beasts and orc wyverns, for your tabletop fantasy armies!", "Тут будуистория проекта №2", "Тут будут линки на видео и демо проекта №2");
		
		project1.setCategory(category1);
		project2.setCategory(category1);
		project3.setCategory(category1);
		
		Projects projects = new Projects();
		projects.add(project1);
		projects.add(project2);
		projects.add(project3);
		
		Kickstarter kickstarter = new Kickstarter(categories, projects);
		kickstarter.run();
	}

	private void run() {
		Quotations quotations = new Quotations();
		System.out.println(quotations.nextQuote());
		while(true){
		System.out.println();
		System.out.println("Выберите категорию:");
		System.out.println(Arrays.toString(categories.getCategories()));
		Scanner scanner = new Scanner(System.in);
		int categoryIndex = scanner.nextInt();
		Category category = categories.getName(categoryIndex);
		System.out.println("Вы выбрали категорию " + category.getName());
		while(true){
		System.out.println();
		System.out.println("Выберите проект:");
		System.out.println("------------------------------------");
		Project[] foundProjects = projects.getProjects(category);
		for(Project project : foundProjects){
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
		if(projectIndex == 0)break;
		Project project = projects.getName(projectIndex);
		System.out.println("Вы выбрали проект " + project.getName());
		System.out.println();
		Project[] foundProjects2 = projects.getFullProject(projectIndex);
			System.out.println("Название проекта:           " + foundProjects2[0].getName());
			System.out.println("Описание проекта:           " + foundProjects2[0].getDescription());
			System.out.println("Необходимая сумма:          " + foundProjects2[0].getGoal() + "$");
			System.out.println("Собранная сумма:            " + foundProjects2[0].getPledged() + "$");
			System.out.println("До окончания сбора средств: " + foundProjects2[0].getDaysLeft() + " дней");
			System.out.println("История проекта:            " + foundProjects2[0].getHistory());
			System.out.println("Линки на видео с демо       " + foundProjects2[0].getLinksToVideo());
			System.out.println("Вопросы/ответы:             " + foundProjects2[0].getQuestions());
			System.out.println("------------------------------------");
			System.out.println("Введите 0 для выхода");
			int exit = scanner.nextInt();
		}
	}
}
}