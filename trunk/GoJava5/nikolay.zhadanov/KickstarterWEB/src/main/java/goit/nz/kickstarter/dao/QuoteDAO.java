package goit.nz.kickstarter.dao;

import goit.nz.kickstarter.domain.Quote;

import java.util.List;

public interface QuoteDAO {

	abstract List<Quote> getQuotes();

}