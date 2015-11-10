package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class ConsolePrinter {
	private static final String deflector = "===========================";
	public static void println(String s){
		System.out.println(s);
	}
	public static void printDeflector(){
		System.out.println(deflector);
	}
	public static void println(Quote quote) {
		System.out.println("\"" + quote.getQuoteName() + "\"\n" + quote.getAuthor());
		
	}
	public static void printCategory(Category b) {
		System.out.println(b.getCategoryId() + "# " + b.getCategoryName());
		
	}
}
