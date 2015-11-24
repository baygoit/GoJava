package ua.com.goit.gojava7.kickstarter.console;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleScannerTest {	

	BufferedReader bufferedReader = org.mockito.Mockito.mock(BufferedReader.class);

	@Mock
	private PrintStream printStream;

	@InjectMocks
	private ConsoleScanner consoleScanner = new ConsoleScanner();

	@Before
	public void setUp() {		
		System.setOut(printStream);
	}
	
	@Test
	public void testGetIntEntered0() throws IOException {
		when(bufferedReader.readLine()).thenReturn("0");
		assertThat(consoleScanner.getInt(0, 3), is(0));
	}

	@Test
	public void testGetIntEntered1() throws IOException {
		when(bufferedReader.readLine()).thenReturn("1");
		assertThat(consoleScanner.getInt(0, 3), is(1));
	}

	@Test
	public void testGetIntEnteredWrongNumberThenEntered0() throws IOException {	
		when(bufferedReader.readLine()).thenReturn("10").thenReturn("0");
		assertThat(consoleScanner.getInt(0, 3), is(0));
		verify(printStream).println(contains("You should type a number FROM 0 TO 3"));
	}

	@Test
	public void testGetIntEnteredNotNumberThenEntered0() throws IOException {	
		when(bufferedReader.readLine()).thenReturn("ssssss").thenReturn("0");
		assertThat(consoleScanner.getInt(0, 3), is(0));
		verify(printStream).println(contains("You should type a NUMBER from 0 to 3"));
	}

	@Test
	public void testGetOptionEnteredA() throws IOException {
		when(bufferedReader.readLine()).thenReturn("a");
		assertThat(consoleScanner.getOption(), is("a"));
	}

	@Test
	public void testGetOptionEnteredB() throws IOException {
		when(bufferedReader.readLine()).thenReturn("b");
		assertThat(consoleScanner.getOption(), is("b"));
	}

	@Test
	public void testGetOptionEntered0() throws IOException {	
		when(bufferedReader.readLine()).thenReturn("0");
		assertThat(consoleScanner.getOption(), is("0"));
		verify(printStream).println(contains("Type:"));
	}

	@Test
	public void testGetOptionEnteredWrongCharacterThan0() throws IOException {
		when(bufferedReader.readLine()).thenReturn("5").thenReturn("0");
		assertThat(consoleScanner.getOption(), is("0"));
		verify(printStream, times(2)).println(contains("Type:"));
	}

	@Test
	public void testGetString() throws IOException {
		when(bufferedReader.readLine()).thenReturn("kdkadkw29w90");
		assertThat(consoleScanner.getString(), is("kdkadkw29w90"));
	}
	
	@Test
	public void testClose() throws IOException {
		consoleScanner.close();
		verify(bufferedReader).close();
	}
}
