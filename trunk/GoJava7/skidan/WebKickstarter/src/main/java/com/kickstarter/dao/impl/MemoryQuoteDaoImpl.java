package com.kickstarter.dao.impl;

import java.util.List;

import com.kickstarter.dao.interfaces.QuoteDaoInterface;
import com.kickstarter.memory.storage.QuoteStorage;
import com.kickstarter.model.Quote;

public class MemoryQuoteDaoImpl implements QuoteDaoInterface {
	
	QuoteStorage qs = new QuoteStorage();

	public Quote get() {
		
		List<Quote> list = QuoteStorage.quotes;
		
	return list.get((int) (Math.random() * list.size()));

		}

	
}


