package ua.com.goit.gojava.alexfurman.kickstarter.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.alexfurman.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava.alexfurman.kickstarter.entity.Quote;

@Service
public class QuoteService {

	@Autowired
	private QuoteDAO quoteDAO;
	
	public Quote getRandomQuote() {
		int i = new Random().nextInt((Integer) quoteDAO.size());
		return quoteDAO.getQuoteById(i + 1);
	}	
}
