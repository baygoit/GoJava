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

	// метод надо сделать пабликом, чтобы его было визно запределами класса. Это жеж наш основной класс
	public void run() {		
		QuoteGenerator generator = new QuoteGenerator();
		System.out.println(generator.nextQuote());
		
		while (true) {
			System.out.println();
			System.out.println("Выберите категорию:");
			System.out.println(Arrays.toString(categories.getCategories()));
			
			Scanner scanner = new Scanner(System.in);
			int categoryIndex = scanner.nextInt();
	
			Category category = categories.getName(categoryIndex);
			System.out.println("Вы выбрали категорию: " + category.getName());
			
			System.out.println("--------------------------------------"); 
			Project[] foundProjects = projects.getProjects(category);
			
			for (Project project : foundProjects) {
				System.out.println(project.getName());
				System.out.println(project.getDescription()); 
				System.out.println("Уже собрали " + project.getAmount() + " грн за " + project.getDays() + " дней"); 
				System.out.println("Надо собрать " + project.getExist() + " грн");
				System.out.println("--------------------------------------"); 				
			}
		}
	}
}
