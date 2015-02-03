package ua.com.scread.kickstarter;

import java.util.Random;

public class Kickstarter {
	
	public static void main(String[] args) {
	    Model model = new Model();
	    model.init();
	    
		KickstarterRunner kickstarter = new KickstarterRunner(model, new ConsoleIO(), 
		                                new QuoteGenerator(new Random()));
		
		kickstarter.run();
	}
}
