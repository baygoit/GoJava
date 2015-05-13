package ua.com.goit.gojava.kickstarter;

import java.util.Random;

public class Kickstarter {

    public static void main(String[] args) {
	Kickstarter application = new Kickstarter();
	application.run();
    }

    private void run() {
	
	QuotesGenerator generator = new QuotesGenerator();
	System.out.println(generator.nextQuote());
	
    }

}
