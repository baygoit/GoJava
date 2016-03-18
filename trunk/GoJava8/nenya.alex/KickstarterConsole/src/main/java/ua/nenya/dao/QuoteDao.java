package ua.nenya.dao;

import java.util.Random;

import ua.nenya.project.Quote;

public interface QuoteDao {
	
	void initQuotes();
	
	Quote getRandomQuote(Random random);
}
