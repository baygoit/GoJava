package ua.home.kickstarter.controller;

import ua.home.kickstarter.content.Quote;
import ua.home.kickstarter.model.QuotationsStorage;

public class QuotationsController {
	private QuotationsStorage quotationsStorage;

	public QuotationsController() {
		quotationsStorage = new QuotationsStorage();
	}

	public Quote passRandomQuoteToView() {
		return quotationsStorage.getRandomQuote();
	}

}
