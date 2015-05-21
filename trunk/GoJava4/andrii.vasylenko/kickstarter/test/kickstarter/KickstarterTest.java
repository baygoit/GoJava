package kickstarter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import kickstarter.interfaces.printers.ConsolePrinter;
import kickstarter.interfaces.printers.Printer;
import kickstarter.interfaces.readers.ConsoleReader;
import kickstarter.interfaces.readers.Reader;

import org.junit.Test;

public class KickstarterTest {
	@Test
	public void test() {
		Runner runner = new Runner();
		Model model = runner.initModel();
		Printer printer = mock(ConsolePrinter.class);
		Reader reader = mock(ConsoleReader.class);
		View view = new View(printer, reader);
		
	}

}
