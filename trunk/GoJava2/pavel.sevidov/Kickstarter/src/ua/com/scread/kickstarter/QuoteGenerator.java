package ua.com.scread.kickstarter;

import java.util.ArrayList;
import java.util.Random;

public class QuoteGenerator {
	public String getQuote() {
		ArrayList<String> quotes = new ArrayList<String>();
		quotes.add("Set your goal lower than you think you need (c) Kickstart");
		quotes.add("Look at successful and unsuccessful campaigns (c) Kickstart");
		quotes.add("Give good rewards (c) Kickstart");
		quotes.add("Make a short, well-produced video (c) Kickstart");
		quotes.add("Thank contributors as they donate (c) Kickstart");
		quotes.add("Promote your project everywhere (c) Kickstart");
		
		int index = new Random().nextInt(quotes.size());
		
		return quotes.get(index);
	}

}
