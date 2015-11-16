package ua.com.goit.gojava7.kickstarter.console;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleScannerTest {

	private ConsoleScanner consoleScanner;
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
	public void testGetInt() {
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		consoleScanner = new ConsoleScanner(in);
		assertThat(consoleScanner.getInt(0, 3), is(1));
	}

	@Test
	public void testGetIntEnteged0() {
		ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
		consoleScanner = new ConsoleScanner(in);
		assertThat(consoleScanner.getInt(0, 3), is(0));
	}

	@Test
	public void testGetIntfrom0To0Entered0() {
		ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
		consoleScanner = new ConsoleScanner(in);
		assertThat(consoleScanner.getInt(0, 0), is(0));
	}

	// @Test
	// public void testGetIntEnteredNotNumber() {
	// PrintStream printSteam = mock(PrintStream.class);
	// System.setOut(printSteam);
	// ByteArrayInputStream in = new ByteArrayInputStream("a".getBytes());
	//
	// consoleScanner = new ConsoleScanner(in);
	// consoleScanner.getInteger(0, 3);
	// verify(printSteam).println(contains("You should type"));
	// //assertThat(consoleScanner.getInteger(0, 3), is(0));
	// }

	@Test
	public void testGetBackOrZeroEntered0() {
		ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
		consoleScanner = new ConsoleScanner(in);
		assertThat(consoleScanner.getMenu(), is("0"));
	}

	@Test
	public void testGetBackOrZeroEnteredB() {
		ByteArrayInputStream in = new ByteArrayInputStream("b".getBytes());
		consoleScanner = new ConsoleScanner(in);
		assertThat(consoleScanner.getMenu(), is("b"));
	}


}
