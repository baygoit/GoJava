package ua.com.goit.gojava7.kickstarter.console;

import static org.junit.Assert.*;

import java.io.BufferedReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ConsoleReaderTest {

	BufferedReader reader = org.mockito.Mockito.mock(BufferedReader.class);
	//private InputStreamReader defaultSystemIn;
	
	@Mock
	//private InputStreamReader inputStream;
	private ConsoleReader consoleReader;
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
