package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.model.Quote;

public class QuoteDAO extends CommonDAO<Quote>{
	
	public QuoteDAO() {
		Quote quote1 = new Quote();
		quote1.setTitle("Liberty will not descend to a people, a people must raise themselves to liberty; "
				+ "it is a blessing that must be earned before it can be enjoyed");
		quote1.setAuthor("B. Franklin");
		
		dataSource.add(quote1);
	}
	
}
