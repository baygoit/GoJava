package com.anna.kickstarter;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

//	public Runner (Categories categories){
//		this.categories = categories;
//	}
	
	public static void main(String[] args) {
		
		Category category1 = new Category("SPORT");
		Category category2 = new Category("MUSIC");
		Category category3 = new Category("DESIGN");
		
		Categories categories = new Categories();
		
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		Runner application = new Runner();
		application.run();
		
		System.out.println(Arrays.toString(categories.getCategories()));
		System.out.print("Choose category: ");
		
		Scanner scanner = new Scanner(System.in);
		int answer = scanner.nextInt();
		scanner.close();
		
		System.out.println("Choosed category: " + categories.getCategory(answer - 1));

		Project project1 = new Project("Обучение катанию на лыжах и борде",500,14);
		Project project2 = new Project("Снаряжение для горнолыжного спорта",2000,30);
		
		Projects projects = new Projects();
		projects.add(project1);
		projects.add(project2);
		
		System.out.println("Thanks for using my program!");
		}

	private void run() {
		QuoteGenerator generator = new QuoteGenerator();
		System.out.println(generator.getQuote());
	}

}
