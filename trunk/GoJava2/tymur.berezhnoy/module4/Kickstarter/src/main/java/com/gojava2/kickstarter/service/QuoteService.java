package com.gojava2.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gojava2.kickstarter.entity.Quote;
import com.gojava2.kickstarter.repository.QuoteRepository;

@Service
public class QuoteService {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	public Quote getRandomQuote() {
//		Quote quote = quoteRepository.getRandomQuote().get(1);
        return quoteRepository.getRandomQuote();
	}
}