package ua.com.scread.kickstarter;

import java.util.Arrays;

public class View {

	public View() {
		
	}
	
	public void greed() {
		QuoteGenerator quote = new QuoteGenerator();
		System.out.println(quote.getQuote());
	}

	public void showCategoies(Categories categories) {
		System.out.println("\nChoose category: ");
		System.out.println(Arrays.toString(categories.getStringCategories()));
	}

	public void showCategory(Category category) {
		System.out.println("You choosed: " + category.getName());
	}
	
	
}
