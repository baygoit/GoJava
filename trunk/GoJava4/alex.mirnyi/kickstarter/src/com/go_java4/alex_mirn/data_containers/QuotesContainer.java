package com.go_java4.alex_mirn.data_containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.go_java4.alex_mirn.data.Quote;

public class QuotesContainer {
	private List<Quote> quotes;

	public QuotesContainer() {
		quotes = new ArrayList<Quote>();
	}

	public void add(Quote quote) {
		quotes.add(quote);
	}

	public Quote get(int index) {
		return quotes.get(index);
	}

	public int size() {
		return quotes.size();
	}

	public Quote getRandom() {
		int randomIndex = getRandomIndex();
		return quotes.get(randomIndex);
	}

	private int getRandomIndex() {
		return new Random().nextInt(size());
	}

}
