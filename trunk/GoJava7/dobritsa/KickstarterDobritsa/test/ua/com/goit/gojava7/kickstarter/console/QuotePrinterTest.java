package ua.com.goit.gojava7.kickstarter.console;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

@RunWith(MockitoJUnitRunner.class)
public class QuotePrinterTest {

	private QuotePrinter quotePrinter = new QuotePrinter();
	private PrintStream systemOut;

	@Before
	public void setUp() {
		systemOut = System.out;
	}

	@After
	public void tearDown() {
		System.setOut(systemOut);
	}

	@Test
	public void testPrint() {
		PrintStream printSteam = mock(PrintStream.class);
		System.setOut(printSteam);
		quotePrinter.print(new Quote("text1", "author"));
		verify(printSteam).println(contains("text"));
		verify(printSteam).println(contains("author"));
	}

	@Test
	public void testPrintRandomQuote() {
		PrintStream printSteam = mock(PrintStream.class);
		System.setOut(printSteam);
		QuoteStorage quoteStorage = new QuoteStorage();
		quoteStorage.add(new Quote("text1", "author"));
		quotePrinter.printRandomQuote(quoteStorage);
		verify(printSteam).println(contains("text"));
		verify(printSteam).println(contains("author"));
	}

}
