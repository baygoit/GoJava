package com.kickstarter.memory.storage;

import java.util.ArrayList;
import java.util.List;

import com.kickstarter.model.Quote;

public class QuoteStorage {

	public static List<Quote> quotes;

	public QuoteStorage() {

		quotes = quoteFill();

	}

	public static List<Quote> quoteFill() {

		List<Quote> quotes = new ArrayList<>();

		quotes.add(new Quote("To improve is to change; to be perfect is to change often. ", " Winston_churchill"));
		quotes.add(new Quote("A pessimist sees the difficulty in every opportunity"
				+ " an optimist sees the opportunity in every difficulty ", " Winston Churchill"));
		quotes.add(new Quote("Attitude is a little thing that makes a big difference. ", " Winston Churchill"));

		return quotes;
	}
}


