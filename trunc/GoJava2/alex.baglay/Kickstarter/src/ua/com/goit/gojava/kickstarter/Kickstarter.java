package ua.com.goit.gojava.kickstarter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Kickstarter {

	private Categories categories;
	private Projects projects;
	private IO io; 
	private QuoteGenerator generator; 

	public Kickstarter(Categories categories, Projects projects, IO io, QuoteGenerator generator) {
		this.categories = categories;
		this.projects = projects;
		this.io = io;  
		this.generator = generator;
	}

	public void run() {		
		println(generator.nextQuote());
		
		while (true) {
			askCategory();
			int menu = io.read();
			if (menu == 0) { 
				break; 
			}
			
			Category category = chooseCategory(menu);
			if (category == null) {
				continue; 
			}
			
			Project[] found = projects.getProjects(category);
			printProjects(found);			
			projectMenu(found);
		}
		println("Спасибо за использование нашей программы!");
	}

	private void projectMenu(Project[] found) {
		while (true) { 
			askProject(found);

			int menu = io.read(); 
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
			println("Неверный индекс меню " + menu);
			return null;  
		}
		return found[menu - 1];
	}

	private void println(String message) {
		io.print(message + "\n");
	}
	
	private void askProject(Project[] found) {
		if (found.length == 0) {
			println("Проектов в категории нет. Нажмите 0 - для выхода.");
		} else {
			int from = 1;
			int to = found.length;
			println("Выберите проект: [" + from + "..." + to + "] или 0 для выхода" );
		}
	}

	private void printProjectDetails(Project project) {
		printProject(project);
		
		println(project.getHistory()); 
		println(project.getDemoVideo()); 
		
		String questionAnswers = project.getQuestionAnswers();
		if (questionAnswers != null) {  
			println(questionAnswers); 
		}
		println("--------------------------------------"); 
	}

	private void chooseProject(Project project) {
		println("Вы выбрали проект: " + project.getName());
		println("--------------------------------------");
	}

	private void printProjects(Project[] found) {
		for (int index = 0; index < found.length; index++) {
			Project project = found[index];
			io.print((index + 1) + " - ");  
			printProject(project); 			
		}
	}

	private void printProject(Project project) {
		println(project.getName());
		println(project.getDescription()); 
		println("Уже собрали " + project.getAmount() + " грн за " + project.getDays() + " дней"); 
		println("Надо собрать " + project.getExist() + " грн");
		println("--------------------------------------");
	}

	private void askCategory() {
		println("Выберите категорию (или 0 для выхода):");
		println(Arrays.toString(categories.getCategories()));
	}

	private Category chooseCategory(int menu) {
		if (menu <= 0 || categories.size() < menu) {
			println("Неверный индекс меню " + menu);
			return null; // TODO не рекомендуется так делать, потому что потенциальный NPE у клиента 
		}
		
		// TODO тут надо привести либо везде к одному виду, либо разделять - на вьюхе от 1 до N а в моделе от 0 до N-1 
		Category category = categories.get(menu - 1); 
		println("Вы выбрали категорию: " + category.getName());
		println("--------------------------------------");
		return category;
	}
}
