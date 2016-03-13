package site;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import categories.Category;
import categories.MemoryCard;

public class StartPage extends Page{
	
	public StartPage(Category kickstarter) {
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
		
		ArrayList <String> quotes = new ArrayList<String>();
		MemoryCard mc = new MemoryCard();
		if(mc.switcher == true){
		try (BufferedReader br = new BufferedReader(new FileReader("source/MemoryCardOfQuotes.txt"))) {
			String quote = "";
			for (; (quote = br.readLine()) != null;) {
				quotes.add(quote);
			}
		} catch (IOException e) {
		
			return "";
		}	
		}else{	
		quotes.add("Great minds are always feared by lesser minds.");
		quotes.add("I cannot teach anybody anything. I can only make them think");
		quotes.add("Write what you know. That should leave you with a lot of free time.");
		quotes.add("Last night I lost the world, and gained the universe.");
		quotes.add("People don't care how much you know until they know how much you care");
		}
		Random randomGenerator = new Random();
		int choice = randomGenerator.nextInt(quotes.size());

		return quotes.get(choice);
	}
}