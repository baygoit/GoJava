package com.gojava2.kickstarter.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gojava2.kickstarter.entity.Quote;
import com.gojava2.kickstarter.repository.QuoteRepository;

@Service
public class QuoteService {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	public Quote getRandomQuote() {
        Random random = new Random();
        
        int index = random.nextInt((int) quoteRepository.count());
        return quoteRepository.findOne(index + 1);
	}
}