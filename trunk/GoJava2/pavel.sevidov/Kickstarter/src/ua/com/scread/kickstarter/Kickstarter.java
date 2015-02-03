package ua.com.scread.kickstarter;

import java.util.Random;

public class Kickstarter {
	
	public static void main(String[] args) {
		KickstarterRunner kickstarter = new KickstarterRunner(new Model(), new ConsoleIO(), 
		                                new QuoteGenerator(new Random()));
		
		kickstarter.run();
	}
}
