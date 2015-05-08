package launcher;

import java.util.Scanner;
import entities.*;


public class RunKickstarter {
	
	public static void main(String[] args) {
		
		Quotes quotes = new Quotes();
		Category categories = new Category();
		Project projects = new Project("Super Bicycle",
				1,
				"The fastest bike in the world",
				5000,
				20,
				"Some description",
				"http://www.youtube.com/bicycle",
				"Stupid quastion? - Clever answer");
		
		Project projects2 = new Project("Telephone",
				2,
				"The coolest phone in the world",
				20000,
				169,
				"Some description",
				"http://www.youtube.com/bicycle",
				"Stupid quastion? - Clever answer");
		
		
		quotes.showQuoteMenu();
		categories.showCategoryMenu();
		projects.showShortProjectMenu();
		projects2.showShortProjectMenu();
		
	}
}






