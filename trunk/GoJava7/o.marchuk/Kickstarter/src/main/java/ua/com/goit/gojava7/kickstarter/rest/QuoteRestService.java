package ua.com.goit.gojava7.kickstarter.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@Produces(MediaType.APPLICATION_JSON)
@Path("/quote")
public class QuoteRestService extends SpringBeanAutowiringSupport {

	@Autowired
	private QuoteDao quoteDao;

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	public Quote getQuote() {
		Quote quote = quoteDao.getRandomQuote();
		return quote;
	}
}