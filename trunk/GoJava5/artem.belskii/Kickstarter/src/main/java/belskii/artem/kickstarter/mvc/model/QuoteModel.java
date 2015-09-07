package belskii.artem.kickstarter.mvc.model;

import belskii.artem.kickstarter.dao.quote.QuoteDao;
import belskii.artem.kickstarter.dao.quote.QuoteDaoImplPsql;

public class QuoteModel {
	QuoteDao quoteDao = new QuoteDaoImplPsql("src/main/conf/database.conf");

	public String getRandomQuote() {
		return quoteDao.getRandomQuote();
	}

	public void addQuote(String quote) {
		quoteDao.addQuote(quote);
	}
}
