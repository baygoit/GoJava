package com.kickstarter.dao;

import com.kickstarter.beans.Quote;

public class QuoteDAO extends CommonDAO<Quote>{
	
	public QuoteDAO() {
		dataSource.add(new Quote("Napoleon Hill", "The starting point of all achievement is desire."));
		dataSource.add(new Quote("Audrey Hepburn", "Nothing is impossible, the word itself says 'I'm possible'!"));
		dataSource.add(new Quote("Milton Berle", "If opportunity doesn't knock, build a door."));
	}
	
}
