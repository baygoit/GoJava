package ua.com.sas.dao;

import ua.com.sas.model.Quote;

public interface Quotes {
	
	Quote get(int id);
	
	void add(Quote quote);
	
	int size();
	
}
