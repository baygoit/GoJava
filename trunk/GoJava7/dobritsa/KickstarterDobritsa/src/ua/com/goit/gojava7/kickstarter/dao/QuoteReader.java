package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public interface QuoteReader {
	
	List<Quote> read();

}
