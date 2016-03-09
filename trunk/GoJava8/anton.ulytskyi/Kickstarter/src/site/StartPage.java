package site;

import java.util.Random;

import categories.Book;

public class StartPage extends Page{
	
	public StartPage(Book kickstarter) {
		super(kickstarter);
	}
	@Override
	public void openPage(){
		
		showVision();
		String userChoice = console.read();

		if (userChoice.equals(FIRST_CHOICE)) {
			direction = new CategoryPage(kickstarter);
			direction.openPage();
			
		} else if (userChoice.equals(EXIT)) {
			exit();

		} else {
			openPage();
		}
	}

	@Override
	public void openPreviousPage(){
	}
	@Override
	public void showVision(){
		String quote = chooseQuote();
		console.write(DECORATION);
		console.write(quote);
		console.write(DECORATION);
		console.write("0 - if You want to leave Kickstarter.");
		console.write("1 - if You want to enter to Kickstarter;");
		console.write(DECORATION);
}
	private String chooseQuote() {

		String quotes[]={"Great minds are always feared by lesser minds.",
				"I cannot teach anybody anything. I can only make them think",
				"Write what you know. That should leave you with a lot of free time.",
				"Last night I lost the world, and gained the universe.",
				"People don't care how much you know until they know how much you care"};
		
		Random randomGenerator = new Random();
		int choice = randomGenerator.nextInt(quotes.length);

		return quotes[choice];
	}
}