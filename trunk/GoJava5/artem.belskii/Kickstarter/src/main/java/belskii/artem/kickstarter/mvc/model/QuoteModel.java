package belskii.artem.kickstarter.mvc.model;

import belskii.artem.kickstarter.dao.quote.QuoteDao;
import belskii.artem.kickstarter.dao.quote.QuoteDaoImplHardFile;

public class QuoteModel {
	QuoteDao quoteDao = new QuoteDaoImplHardFile();
	
	public String getRandomQuote(){
		return quoteDao.getRandomQuote();
	}
	
	public void addQuote(String quote){
		quoteDao.addQuote(quote);
	}
}
