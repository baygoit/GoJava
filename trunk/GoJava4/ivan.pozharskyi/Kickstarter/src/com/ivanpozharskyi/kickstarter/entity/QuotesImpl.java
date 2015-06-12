package com.ivanpozharskyi.kickstarter.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class QuotesImpl implements Quotes{
	private ReaderFromFile readerFromFile;
	private List<Quote> quotes = new ArrayList<Quote>();

	public QuotesImpl() {

	}
	public void addQuotesFromFile(String fileName) throws IOException{
		readerFromFile = new ReaderFromFile(fileName);
		List<String> quotesNames = readerFromFile.read();
		for(String quoteName: quotesNames){
			Quote quote = new Quote(quoteName);
			quotes.add(quote);
		}
	}
	@Override
	public void addQuote(Quote quote) {
		quotes.add(quote);
		
	}
	@Override
	public int getSize() {
		
		return quotes.size();
	}
	@Override
	public Quote getRandom() {
		Random rand = new Random();
		return quotes.get(rand.nextInt(4));
	}
	
}
