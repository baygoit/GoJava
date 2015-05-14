package kickstarter.interfaces.printers;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class ConsolePrinterTest {

	@Test
	public void shouldOutputStringMessage_whenShowMessage() {
		PrintStream defaultStream = System.out;
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream myStream = new PrintStream(outputStream);;
		
		System.setOut(myStream);
		
		Printer printer = new ConsolePrinter();
		printer.showMessage("TEST MESSAGE");
		String result = outputStream.toString();
		
		System.setOut(defaultStream);
		
		assertEquals("TEST MESSAGE\r\n", result);
	}

}
