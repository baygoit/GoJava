package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public interface QuoteDAO extends DataSource<Quote>{
    Quote getRandom();
}
