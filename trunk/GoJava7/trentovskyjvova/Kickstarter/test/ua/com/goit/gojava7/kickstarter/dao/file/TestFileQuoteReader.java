package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.Random;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class TestFileQuoteReader {
	private File testQuotesFile;
	private FileQuoteReader fileQuoteReader;
	private Random randon = new Random(42);
	
	@Test
	public void testReadQuotes() {
		testQuotesFile = new File("./resources/quotes.csv");
		fileQuoteReader = new FileQuoteReader(testQuotesFile, randon);
		assertThat(fileQuoteReader.getRandomQuote().getText(), is("I am quote3"));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testReadQuotesNotQuotesInFile() {
		testQuotesFile = new File("./resources/noquotes.csv");
		fileQuoteReader = new FileQuoteReader(testQuotesFile, randon);
		fileQuoteReader.getRandomQuote();
	}

	@Test(expected = WrongFileFormatException.class)
	public void testReadQuotesNoQuotesFile() {
		testQuotesFile = new File("./resources/notExistentQuotes.csv");
		fileQuoteReader = new FileQuoteReader(testQuotesFile, randon);
		fileQuoteReader.getRandomQuote();
	}
}
