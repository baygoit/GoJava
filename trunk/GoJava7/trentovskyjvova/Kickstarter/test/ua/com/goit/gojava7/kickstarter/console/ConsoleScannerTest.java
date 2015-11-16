package ua.com.goit.gojava7.kickstarter.console;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class ConsoleScannerTest {

	private ConsoleScanner consoleScanner;

	
	@Test
	public void testScanEnter1() {
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());

		consoleScanner = new ConsoleScanner(in);
		
		assertThat(consoleScanner.scan(), is(1));
	}

	@Test
	public void testScanEnterNothing4() {
		ByteArrayInputStream in = new ByteArrayInputStream("sdfsdv fsfd\n\n4".getBytes());

		consoleScanner = new ConsoleScanner(in);
		
		assertThat(consoleScanner.scan(), is(4));
	}
	
	@Test
	public void testScanString() {
		ByteArrayInputStream in = new ByteArrayInputStream("djsdjhsdf".getBytes());

		consoleScanner = new ConsoleScanner(in);
		
		assertThat(consoleScanner.scanLine(), is("djsdjhsdf"));
	}
}
