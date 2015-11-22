package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.dao.file.FileQuoteReader;

public class FileQuoteReaderTest {


	@Test
	public void testReadQuotes() {
		File testQuotesFile = new File("./resources/quotes.txt");
		FileQuoteReader fileQuoteReader = new FileQuoteReader(testQuotesFile);
		assertThat(fileQuoteReader.readQuotes().size(), is(2));
	}

	@Test(expected = IllegalStateException.class)
	public void testReadQuotesNotQuotesInFile() {
		File testQuotesFile = new File("./resources/noQuotes.txt");
		FileQuoteReader fileQuoteReader = new FileQuoteReader(testQuotesFile);
		fileQuoteReader.readQuotes();
	}

	@Test(expected = IllegalStateException.class)
	public void testReadQuotesNoQuotesFile() {
		File testQuotesFile = new File("./resources/notExistentQuotes.txt");
		FileQuoteReader fileQuoteReader = new FileQuoteReader(testQuotesFile);
		fileQuoteReader.readQuotes();
	}

}
