package com.ivanpozharskyi.kickstarter.datastorage;

import java.util.Random;


public class QuotesStorage {
	private static final int AMOUNT_OF_QUOTES = 9;
	private Quote [] quotes = new Quote[AMOUNT_OF_QUOTES];
	public QuotesStorage() {
		addAll();		
		}		
	
	private void addAll(){
		quotes[1] = new Quote("Vivere est militare");
		quotes[2] = new Quote("Audiator et altera parse");
		quotes[3] = new Quote("Arbor mala mala mala");
		quotes[4] = new Quote("Dea deas docet");
		quotes[5] = new Quote("Salus populi suprema lex");
		
	}
	public Quote getRandomQuote(){
		Random rand = new Random();
		return quotes[rand.nextInt(AMOUNT_OF_QUOTES)];
		
	}
	
}
