package com.anna.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class QuoteGenerator {
	private List<String> qoutes;
	
	public QuoteGenerator() {
		qoutes = new ArrayList<String>();
		init();
	}

	private void init() {
		qoutes.add("Don't cry because it's over, smile because it happened.");
		qoutes.add("It does not do to dwell on dreams and forget to live.");
		qoutes.add("Everything you can imagine is real.");
		qoutes.add("Some infinities are bigger than other infinities.");
		qoutes.add("Reality continues to ruin my life.");
	}

	public String getQuote() {		
		return qoutes.get((int) (Math.random()*qoutes.size()));
	}
}
