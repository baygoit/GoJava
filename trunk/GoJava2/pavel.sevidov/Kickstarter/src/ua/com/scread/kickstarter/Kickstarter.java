package ua.com.scread.kickstarter;

import java.util.Arrays;
import java.util.Scanner;

public class Kickstarter {
	private Categories categories;
	
	public Kickstarter(Categories categories) {
		this.categories = categories;
	}

	/* 
	*	UserStory II
	*	Как гость я хочу видеть список категорий, с тем чтобы сфокусироваться на интересующей меня теме
	*	Сценарий: Захожу в приложение -> вижу пронумерованный список категорий и запрос на выбор 
	*	категории -> выбираю категорию по номеру -> Вижу сообщение о том, что я выбрал
	*/
	
	public static void main(String[] arguments) {
		Category category1 = new Category("Sport");
		Category category2 = new Category("Science");
		Category category3 = new Category("Virtual reality");
		
		Categories categories = new Categories();
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		Kickstarter kickstarter = new Kickstarter(categories);
		
		kickstarter.run();
	}

	public void run() {
		QuoteGenerator quote = new QuoteGenerator();
		System.out.println(quote.getQuote());
		
		System.out.println("\nChoose category: ");
		System.out.println(Arrays.toString(categories.getCategories()));
		
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.close();
		
		Category category = categories.getCategory(choice);
		System.out.println("You choosed: " + category.getName());
	}
}
