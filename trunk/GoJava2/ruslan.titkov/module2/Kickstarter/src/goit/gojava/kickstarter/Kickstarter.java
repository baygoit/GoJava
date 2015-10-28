package goit.gojava.kickstarter;

import java.util.Random;

public class Kickstarter {

	public static void main(String[] arguments) {
		
		Kickstarter application = new Kickstarter();
		application.run();
	}
	private void run() {
		QuoteGenerator generator = new QuoteGenerator();
		System.out.println(generator.nextQuote());
	}
	
}
