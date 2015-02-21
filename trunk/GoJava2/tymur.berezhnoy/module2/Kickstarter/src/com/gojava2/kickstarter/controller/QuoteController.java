package com.gojava2.kickstarter.controller;

import java.util.List;

import com.gojava2.kickstarter.behavior.ControllerBehavior;
import com.gojava2.kickstarter.content.Quote;
import com.gojava2.kickstarter.factory.StorageFactory;
import com.gojava2.kickstarter.model.QuoteStorage;

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