package ua.com.goit.gojava7.kickstarter.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Matchers.anyListOf;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.powermock.modules.junit4.PowerMockRunner;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Quote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringBeanAutowiringSupport.class)
public class startServletTest {

	@Mock
	private QuoteDao quoteDao;
	
	@Mock
	private CategoryDao categoryDao;
	
	@InjectMocks
	private ProjectController projectController;

	@Ignore
	@Test
	public void testDoGet() throws ServletException, IOException {
		Quote quote = new Quote();
		quote.setText("quote text");
		quote.setAuthor("quote author");
		when(quoteDao.getRandomQuote()).thenReturn(quote);

		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getRequestDispatcher(anyString())).thenReturn(mock(RequestDispatcher.class));

		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);

		//startServlet.doGet(request, response);

		verify(request).setAttribute("quote", quote);
		verify(request).setAttribute(eq("categories"), anyListOf(Category.class));
	}
}
