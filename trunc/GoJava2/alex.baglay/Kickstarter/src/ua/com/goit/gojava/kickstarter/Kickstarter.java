package ua.com.goit.gojava.kickstarter;

import java.util.Arrays;
import java.util.Scanner;

public class Kickstarter {

	private Categories categories;
	private Projects projects; 

	public Kickstarter(Categories categories, Projects projects) {
		this.categories = categories;
		this.projects = projects;
	}

	public void run() {		
		QuoteGenerator generator = new QuoteGenerator();
		System.out.println(generator.nextQuote());
		
		while (true) {
			askCategory();
			int menuIndex = selectMenu(); 
			Category category = chooseCategory(menuIndex);
			if (category == null) {
				continue; 
			}
			
			Project[] foundProjects = projects.getProjects(category);
			printProjects(foundProjects);
			
			while (true) { 
				askProject(foundProjects);
	
				int projectMenuIndex = selectMenu(); 
				Project project = chooseProject(projectMenuIndex, foundProjects);
				if (project == null) {
					continue;
				}
				
				chooseProject(project); 													
				printProjectDetails(project);
				
				// ну и пока не перешли к следующей категории можно предложить пользователю снова выбрать другой проект,
				// то есть надо зациклить вот так
				// да цикл бесконечный, потому мы тут поставим TODO и разберемся что делать дальше (это уже следующая история)
			}
		}
	}

	// и вообще я бы это безобразие выделил в отдельный метод
	private Project chooseProject(int projectMenuIndex, Project[] foundProjects) {
		if (projectMenuIndex <= 0 || foundProjects.length < projectMenuIndex) {
			System.out.println("Неверный индекс меню " + projectMenuIndex);
			return null;  
		}
		return foundProjects[projectMenuIndex - 1];
	}

	private void askProject(Project[] foundProjects) {
		int from = 1;
		int to = foundProjects.length;
		System.out.println("Выберите проект: [" + from + "..." + to + "]" ); 
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

	private void printProjects(Project[] foundProjects) {
		for (int index = 0; index < foundProjects.length; index++) {
			Project project = foundProjects[index];
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

	private Category chooseCategory(int menuIndex) {
		if (menuIndex <= 0 || categories.size() < menuIndex) {
			System.out.println("Неверный индекс меню " + menuIndex);
			return null; // не рекомендуется так делать, потому что потенциальный NPE у клиента, но что поделать, пока так - оставим TODO
		}
		
		// тут надо привести либо везде к одному виду, либо разделять - на вьюхе от 1 до N а в моделе от 0 до N-1 TODO подумать наж этим
		Category category = categories.get(menuIndex - 1); 
		System.out.println("Вы выбрали категорию: " + category.getName());
		System.out.println("--------------------------------------");
		return category;
	}

	private int selectMenu() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
}
