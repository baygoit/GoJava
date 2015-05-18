package kickstarter.interfaces.pages;

import kickstarter.storages.QuotesStorage;

public class PagesManipulator {
	public Page getShowRandomQuotePage(QuotesStorage quotes) {
		return new ShowRandomQuotePage(quotes);
	}
}
