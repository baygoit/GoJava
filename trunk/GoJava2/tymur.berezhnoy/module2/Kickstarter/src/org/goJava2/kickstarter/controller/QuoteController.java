package org.goJava2.kickstarter.controller;

import java.util.List;

import org.goJava2.kickstarter.behavior.ControllerBehavior;
import org.goJava2.kickstarter.content.Quote;
import org.goJava2.kickstarter.factory.StorageFactory;

public class QuoteController implements ControllerBehavior<Integer> {
	
	@Override
	public List<Quote> passContentToView() {
		return StorageFactory.getQuoteStorage().getContent();
	}
	
	@Override
	public Quote passSpecificContentToView(Integer i) {
		return StorageFactory.getQuoteStorage().getSpecificContent(i);	
	}
	
	public Quote passRandomQuoteToView() {
		return StorageFactory.getQuoteStorage().getRandomQuote();
	}
}