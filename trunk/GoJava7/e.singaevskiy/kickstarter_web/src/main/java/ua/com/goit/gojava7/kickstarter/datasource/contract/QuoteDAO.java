package ua.com.goit.gojava7.kickstarter.datasource.contract;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public interface QuoteDAO extends DataSource<Quote>{
    Quote getRandom();
}
