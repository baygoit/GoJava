package belskii.artem.kickstarter.mvc.model;

import belskii.artem.kickstarter.dao.quote.QuoteDao;
import belskii.artem.kickstarter.dao.quote.QuoteDaoImplHardCoding;

public class QuoteModel {
	QuoteDao quoteDao = new QuoteDaoImplHardCoding();
	
	public String getRandomQuote(){
		return quoteDao.getRandomQuote();
	}
	
	public void addQuote(String quote){
		quoteDao.addQuote(quote);
	}
}
