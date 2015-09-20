package goit.nz.kickstarter.service;

import goit.nz.kickstarter.dao.QuoteDAO;
import goit.nz.kickstarter.domain.Quote;

import java.util.List;
import java.util.Random;

import org.springframework.transaction.annotation.Transactional;

public class QuoteService {
	private QuoteDAO quoteDAO;

	public QuoteService(QuoteDAO quoteDAO) {
		this.quoteDAO = quoteDAO;
	}

	@Transactional(readOnly = true)
	public Quote getRandomQuote() {
		Random random = new Random();
		List<Quote> quotes = quoteDAO.getQuotes();
		int randomIndex = random.nextInt(quotes.size());
		return quotes.get(randomIndex);
	}
}
