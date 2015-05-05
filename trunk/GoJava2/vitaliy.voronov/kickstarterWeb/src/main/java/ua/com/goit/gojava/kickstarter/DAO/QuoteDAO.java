package ua.com.goit.gojava.kickstarter.DAO;

import org.springframework.stereotype.Component;
import ua.com.goit.gojava.kickstarter.Model.Quote;

@Component
public class QuoteDAO extends AbstractDAO {
	

	public Quote getQuote(int id) {
		Quote quote = (Quote) getSession().get(Quote.class, id);
		return quote;
	}

}
