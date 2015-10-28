package kickstarter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import kickstarter.interfaces.Preparer;
import kickstarter.interfaces.display.CategoriesDisplay;
import kickstarter.interfaces.display.ProjectDisplay;
import kickstarter.interfaces.display.ProjectsDisplay;
import kickstarter.interfaces.display.QuotesDisplay;
import kickstarter.interfaces.printers.Printer;
import kickstarter.interfaces.readers.Reader;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class UserStory1Test {

	private ArgumentCaptor<String> messages;

	@Before
	public void initKickstarter() {
		Printer printer = mock(Printer.class);

		Reader reader = mock(Reader.class);

		programmingReaderOnlyForRunAndExit(reader);

		runKickstarter(printer, reader);

		messages = getDisplayedMessages(printer);
	}

	@Test
	public void shouldDisplaySomeQuote_whenRunKickstarter() {

		int indexOfFirstMessage = 0;
		String result = messages.getAllValues().get(indexOfFirstMessage);

		assertTrue(result.contains("Quote:"));
		assertTrue(result.length() > "Quote:".length());

	}

	@Test
	public void shouldDisplayGoodLuck_whenExitFromKickstarter() {

		int indexOfLastMessage = messages.getAllValues().size() - 1;
		String result = messages.getAllValues().get(indexOfLastMessage);

		assertEquals("Good Luck!", result);

	}

	private void runKickstarter(Printer printer, Reader reader) {
		Kickstarter kickstarter = new Kickstarter(initModel(), new View(printer, reader), new Preparer(new QuotesDisplay(), new CategoriesDisplay(), new ProjectsDisplay(), new ProjectDisplay()));
		kickstarter.run();
	}

	private ArgumentCaptor<String> getDisplayedMessages(Printer printer) {
		ArgumentCaptor<String> result = ArgumentCaptor.forClass(String.class);

		verify(printer, atLeastOnce()).showMessage(result.capture());

		return result;
	}

	private Model initModel() {
		Runner runner = new Runner();
		return runner.initModel();
	}

	private void programmingReaderOnlyForRunAndExit(Reader reader) {
		try {
			when(reader.getLine()).thenReturn("0");
		} catch (IOException e) {
			fail("IOException from getLine method");
		}
	}
}
