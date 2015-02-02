package ua.com.goit.gojava.kickstarter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Kickstarter {

	private Categories categories;
	private Projects projects; 

	public Kickstarter(Categories categories, Projects projects) {
		this.categories = categories;
		this.projects = projects;
	}

	public void run() {		
		QuoteGenerator generator = new QuoteGenerator(new Random()); // тут тоже надо вставить но уже настоящий Random
		System.out.println(generator.nextQuote());
		
		while (true) {
			askCategory();
			int menu = selectMenu(); 
			Category category = chooseCategory(menu);
			if (category == null) {
				continue; 
			}
			
			Project[] found = projects.getProjects(category);
			printProjects(found);			
			projectMenu(found);
		}
	}

	private void projectMenu(Project[] found) {
		while (true) { 
			askProject(found);

			int menu = selectMenu(); 
			if (menu == 0) {
				break; 
			}
			
			Project project = chooseProject(menu, found);
			if (project == null) {
				continue;
			}
			
			chooseProject(project); 													
			printProjectDetails(project);
		}
	}

	private Project chooseProject(int menu, Project[] found) {
		if (menu <= 0 || found.length < menu) {
			System.out.println("Неверный индекс меню " + menu);
			return null;  
		}
		return found[menu - 1];
	}

	private void askProject(Project[] found) {
		if (found.length == 0) {
			System.out.println("Проектов в категории нет. Нажмите 0 - для выхода.");
		} else {
			int from = 1;
			int to = found.length;
			System.out.println("Выберите проект: [" + from + "..." + to + "] или 0 для выхода" );
		}
	}

	private void printProjectDetails(Project project) {
		printProject(project);
		
		System.out.println(project.getHistory()); 
		System.out.println(project.getDemoVideo()); 
		
		String questionAnswers = project.getQuestionAnswers();
		if (questionAnswers != null) {  
			System.out.println(questionAnswers); 
		}
		System.out.println("--------------------------------------"); 
	}

	private void chooseProject(Project project) {
		System.out.println("Вы выбрали проект: " + project.getName());
		System.out.println("--------------------------------------");
	}

	private void printProjects(Project[] found) {
		for (int index = 0; index < found.length; index++) {
			Project project = found[index];
			System.out.print((index + 1) + " - "); // еще тут :)
			printProject(project); 			
		}
	}

	private void printProject(Project project) {
		System.out.println(project.getName());
		System.out.println(project.getDescription()); 
		System.out.println("Уже собрали " + project.getAmount() + " грн за " + project.getDays() + " дней"); 
		System.out.println("Надо собрать " + project.getExist() + " грн");
		System.out.println("--------------------------------------");
	}

	private void askCategory() {
		System.out.println("Выберите категорию:");
		// для начала тут выводится список
		System.out.println(Arrays.toString(categories.getCategories()));
	}

	private Category chooseCategory(int menu) {
		if (menu <= 0 || categories.size() < menu) {
			System.out.println("Неверный индекс меню " + menu);
			return null; // не рекомендуется так делать, потому что потенциальный NPE у клиента, но что поделать, пока так - оставим TODO
		}
		
		// тут надо привести либо везде к одному виду, либо разделять - на вьюхе от 1 до N а в моделе от 0 до N-1 TODO подумать наж этим
		Category category = categories.get(menu - 1); 
		System.out.println("Вы выбрали категорию: " + category.getName());
		System.out.println("--------------------------------------");
		return category;
	}

	private int selectMenu() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
}
