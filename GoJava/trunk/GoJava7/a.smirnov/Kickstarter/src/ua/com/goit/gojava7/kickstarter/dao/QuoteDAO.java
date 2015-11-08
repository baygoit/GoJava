package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuoteDAO extends CommonDAO<Quote> {

	public QuoteDAO() {
		Quote quote1 = new Quote();
		quote1.setQuoteText("Liberty will not descend to a people, a people must "
				+ "raise themselves to liberty; it is a blessing that must " + "be earned before it can be enjoyed");
		quote1.setAuthor("B. Franklin");

		Quote quote2 = new Quote();
		quote2.setQuoteText("Government's first duty is to protect the people, not " + "run their lives.");
		quote2.setAuthor("Ronald Reagan");

		Quote quote3 = new Quote();
		quote3.setQuoteText("The most terrifying words in the English language are: "
				+ "I'm from the government and I'm here to help.");
		quote3.setAuthor("Ronald Reagan");

		dataSource.add(quote1);
		dataSource.add(quote2);
		dataSource.add(quote3);
	}

}
