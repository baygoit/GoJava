package ua.com.goit.gojava7.kickstarter.console;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class ConsolePrinter {
	public void print(Quote quote) {
		System.out.println(quote.getText() + "\n     " + 	quote.getAuthor());
		}
	
	public void print(List<Category> categories) {
		System.out.println("\n_________________________________________");
		System.out.println("0: for exit");
		for(int i = 0; i < categories.size(); i++) {
			System.out.println(i + 1 + ": " + categories.get(i).getName());
		}	
	}
}
