package ua.com.goit.gojava7.kickstarter.console;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleScannerTest {

	private InputStream defaultSystemIn;

	@Mock
	private InputStream inputSteam;
	
	private ConsoleScanner consoleScanner;


	@Before
	public void setUp() {
		defaultSystemIn = System.in;
		System.setIn(inputSteam);
		consoleScanner = new ConsoleScanner();

	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(inputSteam);
		System.setIn(defaultSystemIn);
	}

	@Test
	public void testClose() throws IOException {
		consoleScanner.close();

		verify(inputSteam).close();
	}


}
