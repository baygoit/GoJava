package ua.com.goit.gojava7.kickstarter.console;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PrinterTest {

	@Mock
	private PrintStream printSteam;
	
	private Printer printer = new Printer();
	
	@Before
	public void setUp() {		
		System.setOut(printSteam);
	}
	
	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);		
	}
	
	@Test
	public void testPrintString() {
		printer.print("string");

		verify(printSteam).println("string");
	}
}
