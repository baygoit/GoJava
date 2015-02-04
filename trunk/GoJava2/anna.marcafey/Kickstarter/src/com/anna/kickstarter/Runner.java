package com.anna.kickstarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		List<String> qoutes = new ArrayList<String>();
		qoutes.add("Don't cry because it's over, smile because it happened.");
		qoutes.add("It does not do to dwell on dreams and forget to live.");
		qoutes.add("Everything you can imagine is real.");
		qoutes.add("Some infinities are bigger than other infinities.");
		qoutes.add("Reality continues to ruin my life.");
		
		int random = (int) (Math.random()*qoutes.size());
		
		System.out.println(qoutes.get(random));
		
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
