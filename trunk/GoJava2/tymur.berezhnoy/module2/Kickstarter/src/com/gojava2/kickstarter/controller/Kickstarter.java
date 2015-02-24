package com.gojava2.kickstarter.controller;

import com.gojava2.kickstarter.model.CategoryStorageInVM;
import com.gojava2.kickstarter.model.ProjectStorageInVM;
import com.gojava2.kickstarter.model.Quote;
import com.gojava2.kickstarter.model.QuoteStorageInVM;
import com.gojava2.kickstarter.view.ConsoleView;


public class Kickstarter {

	public static void main(String[] args) {
		
		QuoteStorageInVM quoteStorage = new QuoteStorageInVM();
		CategoryStorageInVM categoryStorage = new CategoryStorageInVM();
		
		quoteStorage.addQuote(new Quote("Sometimes when you innovate, you make mistakes."
				+ "\n It is best to admit them quickly, and get on with\n improving your other innovations.", "Steve Jobs"));
		quoteStorage.addQuote(new Quote("Sometimes when you innovate, you make mistakes."
				+ "\n It is best to admit them quickly, and get on with\n improving your other innovations.", "Steve Jobs"));
		quoteStorage.addQuote(new Quote("The common question that gets asked in business is, 'why?'."
				+ "\n That's a good question, but an equally valid question is, 'why not?'", "Jeff Bezos"));
		quoteStorage.addQuote(new Quote("If there is anything that a man can do well,\n I say let him do it. Give him a chance.", "Abraham Lincoln"));
		quoteStorage.addQuote(new Quote("Great leaders, like Steve Jobs or Jeff Bezos, also focused on the long term.", "Reed Hastings"));
		quoteStorage.addQuote(new Quote("When you're curious, you find lots of interesting things to do.", "Walt Disney"));
		
		KickstarterController engine = new KickstarterController(quoteStorage, categoryStorage,
																new ProjectStorageInVM(), new ConsoleView());
		engine.run();
	}
}