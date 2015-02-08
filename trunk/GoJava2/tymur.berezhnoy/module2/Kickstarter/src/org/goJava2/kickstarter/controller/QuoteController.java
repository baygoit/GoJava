package org.goJava2.kickstarter.controller;

import java.util.List;

import org.goJava2.kickstarter.behavior.ControllerBehavior;
import org.goJava2.kickstarter.content.Quote;
import org.goJava2.kickstarter.factory.StorageFactory;
import org.goJava2.kickstarter.model.QuoteStorage;

public class QuoteController implements ControllerBehavior<Integer> {
	
	private QuoteStorage quoteStorage;
	
	public QuoteController() {
		quoteStorage = new StorageFactory().getQuoteStorage();
	}
	
	@Override
	public List<Quote> getContent() {
		return quoteStorage.getContent();
	}
	
	@Override
	public Quote getSpecificContent(Integer i) {
		return quoteStorage.getSpecificContent(i);	
	}
	
	public Quote getRandomQuote() {
		return quoteStorage.getRandomQuote();
	}
}