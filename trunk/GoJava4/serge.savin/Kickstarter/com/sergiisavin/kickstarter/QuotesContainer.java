package com.sergiisavin.kickstarter;

import java.util.Random;

public class QuotesContainer implements Quotes {

	private String[] quotes;
	private int numberOfQuotesStored;
	private static final int INCREASE_ARRAY_SIZE_FACTOR = 2; 
	
	public QuotesContainer(String ... quotes){
		this.quotes = quotes;
		numberOfQuotesStored = quotes.length;
	}

	@Override
	public int getSize() {
		return numberOfQuotesStored;
	}

	@Override
	public void add(String quote) {
		if(quote == null){
			throw new Quotes.IllegalArgumentException();
		}
		if(quotes.length == numberOfQuotesStored){
			doubleSizeAndCloneQuotes();
		}
		quotes[numberOfQuotesStored] = quote; 
		numberOfQuotesStored++;
	}

	private void doubleSizeAndCloneQuotes() {
		String[] tmp = new String[(quotes.length)*INCREASE_ARRAY_SIZE_FACTOR];
		System.arraycopy(quotes, 0, tmp, 0, quotes.length);
		quotes = tmp;
	}

	@Override
	public String getRandomQuote() {
		Random rnd = new Random();
		return quotes[rnd.nextInt(numberOfQuotesStored)];
	}

	@Override
	public void delete(int index) {
		if(index < 0){
			throw new Quotes.IllegalArgumentException();
		}
		if(index < numberOfQuotesStored && index > 0){
			shiftQuotes(index);
		}
		
	}

	private void shiftQuotes(int index) {
		if(index != numberOfQuotesStored - 1){
			String[] copy = createCopyOfQuotesToShift(index);
			System.arraycopy(copy, 0, quotes, index, copy.length);
		}
		numberOfQuotesStored--;
		
	}
	
	private String[] createCopyOfQuotesToShift(int index) {
		int indexOfLastQuote = numberOfQuotesStored - 1;
		int numberOfQuotesToShift = indexOfLastQuote - index;
		String[] quotesCopy = new String[numberOfQuotesToShift];
		System.arraycopy(quotes, index + 1, quotesCopy, 0, numberOfQuotesToShift);
		return quotesCopy;
	}
	
	@Override
	public String get(int i) {
		if(i < 0){
			throw new Quotes.IllegalArgumentException();
		}
		String result = null;
		if(i < numberOfQuotesStored && i >= 0){
			result = quotes[i];
		}
		return result;
	}
	

	
}
