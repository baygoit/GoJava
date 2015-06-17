package vadya_zakusylo.kickstarter.model.dao;

import java.util.List;

import vadya_zakusylo.kickstarter.model.Quote;
import vadya_zakusylo.kickstarter.model.exception.GettingDateException;

public abstract class QuotesDao {

	public abstract List<Quote> getQuotesList() throws GettingDateException;

}
