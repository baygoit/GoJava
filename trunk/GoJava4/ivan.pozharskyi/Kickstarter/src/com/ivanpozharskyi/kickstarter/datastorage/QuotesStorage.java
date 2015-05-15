package com.ivanpozharskyi.kickstarter.datastorage;

import java.util.Random;

public class QuotesStorage {
	private static final int AMOUNT_OF_QUOTES = 9;
	private Quote[] quotes = new Quote[AMOUNT_OF_QUOTES];
	private int size = 0;

	public QuotesStorage() {
		quotes[size] = new Quote("Vivere est militare");
		quotes[size++] = new Quote("Audiator et altera parse");
		quotes[size++] = new Quote("Arbor mala mala mala");
		quotes[size++] = new Quote("Dea deas docet");
		quotes[size++] = new Quote("Salus populi suprema lex");

	}

	public Quote getRandomQuote() {
		Random rand = new Random();
		return quotes[rand.nextInt(size)];

	}

}
