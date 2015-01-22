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

	public static void main(String[] arguments) {		
		Category category1 = new Category("Photo");
		Category category2 = new Category("Video");
		Category category3 = new Category("Music");
		
		Categories categories = new Categories();
		
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		Project project1 = new Project("Фильм \"Как выучить java\"", 100000, 15, 
				"Фильм о том, что учить Java очень даже просто и интересно");
		
		Project project2 = new Project("Фильм \"GoJava\"", 2345, 10, 
				"Фильм о том, как проходит тренинг по Java в GoIT");

		project1.setCategory(category2);
		project2.setCategory(category2); 
		
		Projects projects = new Projects();
		projects.add(project1);
		projects.add(project2);
		
		Kickstarter application = new Kickstarter(categories, projects);
		
		application.run();
	}


	private void run() {		
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
