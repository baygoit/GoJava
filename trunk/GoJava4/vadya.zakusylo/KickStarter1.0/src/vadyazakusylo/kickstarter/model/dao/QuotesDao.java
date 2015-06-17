package vadyazakusylo.kickstarter.model.dao;

import java.util.List;

import vadyazakusylo.kickstarter.model.Quote;
import vadyazakusylo.kickstarter.model.exception.GettingDateException;

public abstract class QuotesDao {

	public abstract List<Quote> getQuotesList() throws GettingDateException;

}
