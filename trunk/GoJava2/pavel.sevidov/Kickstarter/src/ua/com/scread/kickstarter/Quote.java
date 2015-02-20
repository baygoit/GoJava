package ua.com.scread.kickstarter.data;

import java.util.ArrayList;
import java.util.Random;

public class Quote {
	private Random random;
	
	public Quote(Random random) {
		this.random = random;
	}
	
	public String getQuote() {
		ArrayList<String> quotes = new ArrayList<String>();
		quotes.add("Set your goal lower than you think you need (c) Kickstart");
		quotes.add("Look at successful and unsuccessful campaigns (c) Kickstart");
		quotes.add("Give good rewards (c) Kickstart");
		quotes.add("Make a short, well-produced video (c) Kickstart");
		quotes.add("Thank contributors as they donate (c) Kickstart");
		quotes.add("Promote your project everywhere (c) Kickstart");
		
		int index = random.nextInt(quotes.size());
		
		return quotes.get(index);
	}

}
