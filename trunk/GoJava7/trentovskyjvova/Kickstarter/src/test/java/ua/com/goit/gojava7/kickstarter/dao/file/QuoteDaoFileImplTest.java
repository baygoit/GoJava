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
	private static final String PATH = "./././src/test/resources/";

	@Test
	public void testReadQuotes() {
		testQuotesFile = new File(PATH + "quotes.csv");
		quoteDaoFileImpl = new QuoteDaoFileImpl(testQuotesFile, randon);
		assertThat(quoteDaoFileImpl.getRandomQuote().getText(),
				is("I am quote3"));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testReadQuotesNotQuotesInFile() {
		testQuotesFile = new File(PATH + "noquotes.csv");
		quoteDaoFileImpl = new QuoteDaoFileImpl(testQuotesFile, randon);
		quoteDaoFileImpl.getRandomQuote();
	}

	@Test(expected = WrongFileFormatException.class)
	public void testReadQuotesNoQuotesFile() {
		testQuotesFile = new File(PATH + "notExistentQuotes.csv");
		quoteDaoFileImpl = new QuoteDaoFileImpl(testQuotesFile, randon);
		quoteDaoFileImpl.getRandomQuote();
	}
}
