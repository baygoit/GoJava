package ua.com.goit.gojava7.kickstarter.console;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class QuotePrinterTest {

	private QuotePrinter quotePrinter = new QuotePrinter();	
	
	@Mock
	private PrintStream printSteam;

	@Before
	public void setUp() {		
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {			
		verifyNoMoreInteractions(printSteam);
	}

	@Test
	public void testPrint() {		
		Quote quote = new Quote();
		quote.setText("TestQuote");
		quote.setAuthor("TestAuthor");
		
		quotePrinter.print(quote);
		verify(printSteam).println(contains("TestQuote"));
		verify(printSteam).println(contains("TestAuthor"));
	}
}
