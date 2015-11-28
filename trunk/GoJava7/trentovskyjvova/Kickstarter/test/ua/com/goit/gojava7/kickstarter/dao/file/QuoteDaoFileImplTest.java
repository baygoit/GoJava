package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.Random;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class QuoteDaoFileImplTest {
	private File testQuotesFile;
	private QuoteDaoFileImpl quoteDaoFileImpl;
	private Random randon = new Random(42);

	@Test
	public void testReadQuotes() {
		testQuotesFile = new File("./resources/quotes.csv");
		quoteDaoFileImpl = new QuoteDaoFileImpl(testQuotesFile, randon);
		assertThat(quoteDaoFileImpl.getRandomQuote().getText(),
				is("I am quote3"));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testReadQuotesNotQuotesInFile() {
		testQuotesFile = new File("./resources/noquotes.csv");
		quoteDaoFileImpl = new QuoteDaoFileImpl(testQuotesFile, randon);
		quoteDaoFileImpl.getRandomQuote();
	}

	@Test(expected = WrongFileFormatException.class)
	public void testReadQuotesNoQuotesFile() {
		testQuotesFile = new File("./resources/notExistentQuotes.csv");
		quoteDaoFileImpl = new QuoteDaoFileImpl(testQuotesFile, randon);
		quoteDaoFileImpl.getRandomQuote();
	}
}
