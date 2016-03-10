package ua.dborisenko.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.dborisenko.kickstarter.Quote;

public class QuoteDaoFileImplTest {

	private String quotesFileName = "./src/test/resources/quotes.txt";
	private QuoteDaoFileImpl quoteDao = new QuoteDaoFileImpl();

	@Test
	public void testFillAllQuotes() {
		quoteDao.setQuotesFileName(quotesFileName);
		quoteDao.fillAllQuotes();
		Quote quote = quoteDao.getRandomQuote();

		assertThat(quote.getText(), is("Quote"));
		assertThat(quote.getAuthor(), is("Author"));
	}

}
