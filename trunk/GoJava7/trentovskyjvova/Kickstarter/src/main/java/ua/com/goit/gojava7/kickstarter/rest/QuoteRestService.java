package ua.com.goit.gojava7.kickstarter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RequestMapping("/rest")
@RestController
public class QuoteRestService{

	@Autowired
	private QuoteDao quoteDao;
	
	@RequestMapping("/quote")
	public Quote getRandomQuote() {
		
		return quoteDao.getRandomQuote();

	}
}
