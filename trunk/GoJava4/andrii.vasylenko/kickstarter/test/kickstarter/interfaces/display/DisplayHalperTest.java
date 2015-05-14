package kickstarter.interfaces.display;

import static org.junit.Assert.*;

import java.io.IOException;

import kickstarter.engine.Quote;
import kickstarter.interfaces.printers.Printer;
import kickstarter.interfaces.readers.Reader;

import org.junit.Test;

public class DisplayHalperTest {

	private final StringBuilder result = new StringBuilder();
	private final StringBuilder input = new StringBuilder();

	private Printer printer = new Printer() {

		@Override
		public void showMessage(String message) {
			result.append(message);
			result.append("\r\n");
		}
	};

	private Reader reader = new Reader() {

		@Override
		public String getLine() throws IOException {
			int indexOfNewLine = input.indexOf("\r\n");
			String line = input.toString().substring(0, indexOfNewLine);
			input.delete(0, indexOfNewLine + "\r\n".length());
			return line;
		}
	};

	@Test
	public void test() {
		Display<Quote> display = new QuoteDisplay();
		DisplayHalper<Quote> displayHalper = new DisplayHalper<Quote>(printer, reader, display);

		input.append("0\r\n");
		displayHalper.choiceItem("TEST");

		String expectedResult = "--------------------\r\nTEST\r\n0 - exit\r\n";

		assertEquals(expectedResult, result.toString());
	}

}
