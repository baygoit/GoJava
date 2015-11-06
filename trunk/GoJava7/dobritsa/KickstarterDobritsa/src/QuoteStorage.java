

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteStorage {
	
	
	public static final Random RANDOM = new Random();
	
	private static final List<String> QUOTES = new ArrayList<String>();
		{
			QUOTES.add("I work to stay alive. "
					+ "\n(c) Bette Davis");
			QUOTES.add("There is only one boss. The customer. And he can fire everybody"
					+ " in the company from the chairman on down, simply by "
					+ "spending his money somewhere else. "
					+ "\n(c) Sam Walton");
			QUOTES.add("Ideas pull the trigger, but instinct loads the gun. "
					+ "\n(c) Don Marquis");
			QUOTES.add("There are no secrets to success. It is the result of preparation, "
					+ "hard work, and learning from failure. "
					+ "\n(c) Colin Powell");
			QUOTES.	add("Happiness does not come from doing easy work but from the "
					+ "afterglow of satisfaction that comes after the achievement "
					+ "of a difficult task that demanded our best. "
					+ "\n(c) Theodore Isaac Rubin");
		}
				
	
	public static String getRandomQuote(){
		int randomNumber = RANDOM.nextInt(QUOTES.size());
		return QUOTES.get(randomNumber);
	}
	
	public static void printForChoice() {
		for(int i = 0; i < QUOTES.size(); i++) {
			System.out.println(i + 1 + ": " + QUOTES.get(i));
		}
		System.out.println("0: for exit");
	}
}
	

