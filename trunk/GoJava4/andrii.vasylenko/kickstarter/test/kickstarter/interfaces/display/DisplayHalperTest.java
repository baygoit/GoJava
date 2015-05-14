package kickstarter.interfaces.display;

import static org.junit.Assert.*;
import kickstarter.engine.Data;
import kickstarter.engine.Quote;
import kickstarter.interfaces.printers.TestPrinter;
import kickstarter.interfaces.readers.TestReader;
import kickstarter.storages.QuotesStorage;

import org.junit.Test;

public class DisplayHalperTest {

	@Test
	public void shouldExit_whenZeroInput() {
		TestPrinter printer = new TestPrinter();
		TestReader reader = new TestReader();
		Display<Quote> display = new QuoteDisplay();
		DisplayHalper<Quote> displayHalper = new DisplayHalper<Quote>(printer, reader, display);

		reader.append("0");
		displayHalper.choiceItem("TEST");

		String expectedResult = "--------------------\r\nTEST\r\n0 - exit\r\n";

		assertEquals(expectedResult, printer.getResult());
	}

	@Test
	public void shouldExit_whenZeroInput_WithStorage() {
		TestPrinter printer = new TestPrinter();
		TestReader reader = new TestReader();
		Display<Quote> display = new QuoteDisplay();
		DisplayHalper<Quote> displayHalper = new DisplayHalper<Quote>(printer, reader, display, new QuotesStorage());

		reader.append("0");
		displayHalper.choiceItem("TEST");

		String expectedResult = "--------------------\r\nTEST\r\n0 - exit\r\n";
		
		assertEquals(expectedResult, printer.getResult());
	}

	@Test
	public void shouldTryMoreAndExit_whenOneAndZeroInput() {
		TestPrinter printer = new TestPrinter();
		TestReader reader = new TestReader();
		Display<Quote> display = new QuoteDisplay();
		DisplayHalper<Quote> displayHalper = new DisplayHalper<Quote>(printer, reader, display);

		reader.append("1");
		reader.append("0");
		displayHalper.choiceItem("TEST");

		String expectedResult = "--------------------\r\nTEST\r\n0 - exit\r\n";
		expectedResult += "--------------------\r\ntry again please\r\n";
		expectedResult += "--------------------\r\nTEST\r\n0 - exit\r\n";

		assertEquals(expectedResult, printer.getResult());
	}

	@Test
	public void shouldTryMoreAndExit_whenSmthAndZeroInput() {
		TestPrinter printer = new TestPrinter();
		TestReader reader = new TestReader();
		Display<Quote> display = new QuoteDisplay();
		DisplayHalper<Quote> displayHalper = new DisplayHalper<Quote>(printer, reader, display);

		reader.append("dgdfg");
		reader.append("0");
		displayHalper.choiceItem("TEST");

		String expectedResult = "--------------------\r\nTEST\r\n0 - exit\r\n";
		expectedResult += "--------------------\r\ntry again please\r\n";
		expectedResult += "--------------------\r\nTEST\r\n0 - exit\r\n";

		assertEquals(expectedResult, printer.getResult());
	}
	
	@Test
	public void shouldData_whenIdInput() {
		TestPrinter printer = new TestPrinter();
		TestReader reader = new TestReader();
		Display<Quote> display = new QuoteDisplay();
		
		QuotesStorage storage = new QuotesStorage();
		Quote quote = new Quote("quote");
		storage.add(quote);		
		
		DisplayHalper<Quote> displayHalper = new DisplayHalper<Quote>(printer, reader, display, storage);

		reader.append(""+quote.getId());

		Data result = displayHalper.choiceItem("TEST");
		
		assertEquals(quote, result);
	}	
}
