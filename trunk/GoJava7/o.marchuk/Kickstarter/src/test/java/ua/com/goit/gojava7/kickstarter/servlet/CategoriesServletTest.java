package ua.com.goit.gojava7.kickstarter.servlet;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesServletTest {

	@Mock
	private QuoteDao quoteDao;
	@Mock
	private CategoryDao categoryDao;
	@InjectMocks
	private CategoriesServlet categoriesServlet;

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		when(quoteDao.getRandomQuote()).thenReturn(new Quote("quote text", "quote author"));

		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);

		PrintWriter writer = mock(PrintWriter.class);
		when(resp.getWriter()).thenReturn(writer);

		categoriesServlet.doGet(req, resp);

		verify(writer).append(contains("quote text"));
	}

}
