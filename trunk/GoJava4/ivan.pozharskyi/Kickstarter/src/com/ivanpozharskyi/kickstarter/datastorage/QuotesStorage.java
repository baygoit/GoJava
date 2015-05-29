package com.ivanpozharskyi.kickstarter.datastorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class QuotesStorage {
	private ReaderFromFile readerFromFile;
	private List<Quote> quotes = new ArrayList<Quote>();

	public QuotesStorage() {

	}
	public void addQuotesFromFile(String fileName) throws IOException{
		readerFromFile = new ReaderFromFile(fileName);
		List<String> quotesNames = readerFromFile.read();
		for(String quoteName: quotesNames){
			Quote quote = new Quote(quoteName);
			quotes.add(quote);
		}
	}
	public Quote getRandomQuote() {
		Random rand = new Random();
		return quotes.get(rand.nextInt(4));

	}

}
