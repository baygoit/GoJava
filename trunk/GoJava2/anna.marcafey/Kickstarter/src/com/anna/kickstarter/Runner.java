package com.anna.kickstarter;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		System.out.println(new QuoteGenerator().getQuote());
		
		Category category1 = new Category("Category1");
		Category category2 = new Category("Category2");
		
		Categories categories = new Categories();
		
		categories.add(category1);
		categories.add(category2);
		
		System.out.println(Arrays.toString(categories.getCategories()));
		System.out.print("Choose category: ");
		
		Scanner scanner = new Scanner(System.in);
		int answer = scanner.nextInt();
		scanner.close();
		
		System.out.println("Choosed category: " + categories.getCategory(answer - 1));
		
		System.out.println("Thanks for using my program!");


	}

	

}
