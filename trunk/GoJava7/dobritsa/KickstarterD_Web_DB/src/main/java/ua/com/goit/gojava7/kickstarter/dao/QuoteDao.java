package ua.com.goit.gojava7.kickstarter.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Quote;

@Component
public class QuoteDao {

	@Autowired
	private DbDao dbDao;

	private static final Logger log = LoggerFactory.getLogger(QuoteDao.class);

	public QuoteDao() {
		log.info("Constructor QuoteDao()...");
	}

	public Quote getRandomQuote() {
		log.info("<Quote> getRandomQuote()...");
		String query = "SELECT text, author FROM quote order by rand() limit 1 ";
		return dbDao.getQuote(query);
	}	

	public Quote get(int index) {
		log.info("<Quote> get({})...", index);
		String query = "select text, author from quote where id = " + index;
		return dbDao.getQuote(query);
	}
}
