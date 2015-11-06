package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public final class ConsolePrinter {

	private ConsolePrinter() {

	}

	public static void println(Quote quote) {
		System.out.println(quote.getText() + " " + quote.getAuthor());
	}
}
