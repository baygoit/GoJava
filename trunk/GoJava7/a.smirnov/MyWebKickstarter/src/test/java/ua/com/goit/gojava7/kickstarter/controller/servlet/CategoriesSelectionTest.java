package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

public class CategoriesSelectionTest extends Mockito {

	@Mock
	private QuoteDao quoteDao;

	@Mock
	private CategoryDao categoryDao;

	@InjectMocks
	private CategoryServlet categoriesSelection;

	public void testInit() {

	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws IOException, ServletException {
		Quote quote = new Quote();
		quote.setAuthor("TestA");
		quote.setText("testB");

		when(quoteDao.getRandomQuote()).thenReturn(quote);

		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		categoriesSelection.doGet(request, response);

		verify(writer).append(contains("TestA"));
		verify(writer).append(contains("TestB"));
	}
}
