package ua.com.goit.gojava7.kickstarter.handlers;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.handlers.TextModifer;

public class TextModiferTest {
	
	private TextModifer modifer = new TextModifer();
	
	@Test
	public void testGetModifiedQuote() {
		String textQuote = "Hello world";
		String author = "Anton Smirnov";
		
		String result = modifer.getModifiedQuote(textQuote, author);
		String[] array = result.split("\n");
			
		assertEquals(result.contains("(c)"), true);
		assertEquals(result.contains(textQuote), true);
		assertEquals(result.contains(author), true);
		assertEquals(result.contains("\n"), true);
		assertEquals(array[0].length() < 80, true);
		assertEquals(array[1].length() < 80, true);
	}

	@Test
	public void testGetModifiedText() {
		String testing = "Before proceeding with this tutorial, you should have a basic understanding "
				+ "of the software development life cycle (SDLC). In addition, you should have a basic "
				+ "understanding of software programming using any programming language. Testing is "
				+ "executing a system in order to identify any gaps, errors, or missing requirements in "
				+ "contrary to the actual requirements";
	
		String result = modifer.getModifiedText(testing);
		String[] array = result.split("\n");
	
		assertEquals(array[0].length() < 80, true);
		assertEquals(array[1].length() < 80, true);
		assertEquals(array[2].length() < 80, true);
		assertEquals(array[3].length() < 80, true);
		assertEquals(result.contains("\n"), true);
	}
}
