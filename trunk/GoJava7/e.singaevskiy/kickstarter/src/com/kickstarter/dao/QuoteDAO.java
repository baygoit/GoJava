package com.kickstarter.dao;

import com.kickstarter.beans.Quote;

public class QuoteDAO extends CommonDAO<Quote>{
	
	public QuoteDAO() {
		dataSource.add(new Quote("Napoleon Hill", "The starting point of all achievement is desire."));
	}
	
}
