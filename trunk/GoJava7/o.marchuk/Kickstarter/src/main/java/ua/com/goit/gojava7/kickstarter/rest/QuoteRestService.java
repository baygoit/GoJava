package ua.com.goit.gojava7.kickstarter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RestController
@RequestMapping("/rest")
public class QuoteRestService {

	@Autowired
	private QuoteDao quoteDao;

	@RequestMapping("/quote")
	public Quote getQuote() {
		Quote quote = quoteDao.getRandomQuote();
		return quote;
	}
}