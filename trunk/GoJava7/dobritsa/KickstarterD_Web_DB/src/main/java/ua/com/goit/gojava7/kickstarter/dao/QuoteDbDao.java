package ua.com.goit.gojava7.kickstarter.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Quote;

@Component
public class QuoteDbDao {

	@Autowired
	private DbManager dbManager;

	private static final Logger log = LoggerFactory.getLogger(QuoteDbDao.class);

	public QuoteDbDao() {
		log.info("Constructor QuoteDbDao()...");
	}

	public Quote getRandomQuote() {
		log.info("<Quote> getRandomQuote()...");
		String query = "SELECT text, author FROM quote order by rand() limit 1 ";
		return dbManager.getQuote(query);
	}

	public Quote getByNumber(int number) {
		log.info("<Quote> getByNumber()...");
		return get(number);
	}

	public Quote get(int index) {
		log.info("<Quote> get({})...", index);
		String query = "select text, author from quote where id = " + index;
		return dbManager.getQuote(query);
	}

	public int size() {
		log.info("<int> size()...");
		String query = "select count(*) as cnt from quote";
		return dbManager.size(query);
	}
}
