package org.goJava2.kickstarter.controller;
import org.goJava2.kickstarter.model.Quote;

public interface QuoteManagement {
	
	public void createQuote(String content, String author);
	public Quote getQuote();
}