package com.gojava2.kickstarter.controller;

import java.util.List;

import com.gojava2.kickstarter.content.Quote;
import com.gojava2.kickstarter.factory.StorageFactory;
import com.gojava2.kickstarter.model.QuoteStorage;

public class QuoteController implements Controller<Integer> {
	
	private QuoteStorage quoteStorage;
	
	public QuoteController() {
		quoteStorage = new StorageFactory().getQuoteStorage();
	}
	
	@Override
	public List<Quote> getContent() {
		return (List<Quote>) quoteStorage.getContent();
	}
	
	@Override
	public Quote getSpecificContent(Integer i) {
		return quoteStorage.getContent().get(i);	
	}
	
	public Quote getRandomQuote() {
		int randomInex = (int)(Math.random() * quoteStorage.getContent().size());
		return quoteStorage.getContent().get((randomInex));
	}
}