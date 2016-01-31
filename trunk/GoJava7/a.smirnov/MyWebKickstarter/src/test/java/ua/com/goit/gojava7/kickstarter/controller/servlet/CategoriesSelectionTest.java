package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.database.contract.CategoryDao;
import ua.com.goit.gojava7.kickstarter.database.contract.QuoteDao;


public class CategoriesSelectionTest extends Mockito {
	@Mock
	private QuoteDao quoteDao;
	@Mock
	private CategoryDao categoryDao;

	public void testInit() {

	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws IOException, ServletException {
		Quote quote = new Quote();
		quote.setAuthor("TestA");
		quote.setText("testB");

		when(quoteDao.getRandomQuote()).thenReturn(quote);

//		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		

		verify(writer).append(contains("TestA"));
		verify(writer).append(contains("TestB"));
	}
}
