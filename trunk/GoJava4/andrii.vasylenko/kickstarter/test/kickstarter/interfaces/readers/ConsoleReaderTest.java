package kickstarter.interfaces.readers;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class ConsoleReaderTest {

	@Test
	public void shouldInputStringMessage_whenGetLine() throws IOException {
		InputStream defaultStream = System.in;
		
		String inputLine = "Test Line 12345";
		
		ByteArrayInputStream myInputStream = new ByteArrayInputStream(inputLine.getBytes());
		System.setIn(myInputStream);
		
		Reader reader = new ConsoleReader();
		String result = reader.getLine();
		
		System.setIn(defaultStream);
		
		assertEquals(inputLine, result);
	}

}
