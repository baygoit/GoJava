package ua.com.goit.gojava.alexfurman.kickstarter.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.Quote;
import ua.com.goit.gojava.alexfurman.kickstarter.repository.QuoteRepository;

@Service
public class QuoteService {

	@Autowired
	private QuoteRepository quoteRepository;
	
	public Quote getRandomQuote() {
		Random random = new Random();
		
		int index = random.nextInt((int) quoteRepository.count());
		return quoteRepository.findOne(index + 1);
	}

	public List<Quote> getQuotes() {	
		return quoteRepository.findAll();
	}
	
	
}
