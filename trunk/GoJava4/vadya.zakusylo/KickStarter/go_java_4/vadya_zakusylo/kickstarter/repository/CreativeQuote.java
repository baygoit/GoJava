package go_java_4.vadya_zakusylo.kickstarter.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CreativeQuote implements Quote {
	private HashMap<String, String> quotes;

	public CreativeQuote() {
		quotes = new HashMap<String, String>();
		initQuotes();
	}

	public void initQuotes() {
		quotes.put("Franklin D. Roosevelt", "Happiness lies in the joy of achievement and the"
				+ "thrill of creative effort.");
		quotes.put("Henri Matisse", "Creativity takes courage.");
		quotes.put("Einstein", "Creativity is contagious pass it on.");
		quotes.put("John Cleese", "If you want creative workers, give them enough time to play.");
		quotes.put("Alan Kay", "The best way to predict the future is to invent it.");
		quotes.put("Kelly Corrigan", "You have to speak your dream out loud.");
	}

	public String printQuote() {
		Set<Map.Entry<String, String>> keys = quotes.entrySet();
		int randomIndexKey = new Random().nextInt(keys.size());
		int currentIndex = 0;
		String randomKey = null;
		String randomValue = null;
		for (Map.Entry<String, String> key : keys) {
			randomKey = key.getKey();
			if (randomIndexKey == currentIndex) {
				break;
			}
			currentIndex++;
		}
		randomValue = quotes.get(randomKey);
		return randomValue + "\n\t" + randomKey;
	}

}
