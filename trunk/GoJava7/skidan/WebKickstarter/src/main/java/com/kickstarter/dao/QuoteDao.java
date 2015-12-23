package com.kickstarter.dao;

import com.kickstarter.dao.interfaces.DbQuoteImpl;
import com.kickstarter.dao.interfaces.QuoteDaoType;

public class QuoteDao extends QuoteDaoType {
	
	public QuoteDao(){
		
		quoteDaoInterface = new DbQuoteImpl();
	}

}
