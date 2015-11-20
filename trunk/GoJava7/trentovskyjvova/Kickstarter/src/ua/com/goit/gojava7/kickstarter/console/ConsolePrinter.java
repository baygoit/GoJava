package ua.com.goit.gojava7.kickstarter.console;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class ConsolePrinter {

	public void print(Quote quote) {
		System.out.println(quote.getText() + " (c) " + quote.getAuthor());
	}
	
	public void print(String string) {
		System.out.println(string);
	}

	public void print(StringBuilder stringBuilder) {
		System.out.println(stringBuilder);	
	}
}
