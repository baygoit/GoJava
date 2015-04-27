package ua.com.goit.gojava2.vova.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava2.vova.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava2.vova.kickstarter.model.Quote;

@Service("quoteService")
@Transactional
public class QuoteServiceImpl implements QuoteService{

	@Autowired
	private QuoteDao dao;
	
	@Override
	public Quote getQuote() {
		return dao.getQuote();
	}

}
