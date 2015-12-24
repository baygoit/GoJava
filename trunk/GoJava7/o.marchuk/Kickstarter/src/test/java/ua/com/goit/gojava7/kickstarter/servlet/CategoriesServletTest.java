package ua.com.goit.gojava7.kickstarter.servlet;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringBeanAutowiringSupport.class)
public class CategoriesServletTest {

	@Mock
	private QuoteDao quoteDao;
	@Mock
	private CategoryDao categoryDao;
	@InjectMocks
	private CategoriesServlet categoriesServlet;

	@Test
	public void testInit() throws Exception {
		PowerMockito.mockStatic(SpringBeanAutowiringSupport.class);

		categoriesServlet.init();

		PowerMockito.verifyStatic();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(anyObject());
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		Quote quote = new Quote();
		quote.setText("quote text");
		quote.setAuthor("quote author");
		when(quoteDao.getRandomQuote()).thenReturn(quote);

		HttpServletRequest req = mock(HttpServletRequest.class);
		when(req.getRequestDispatcher(anyString())).thenReturn(mock(RequestDispatcher.class));
		HttpServletResponse resp = mock(HttpServletResponse.class);

		PrintWriter writer = mock(PrintWriter.class);
		when(resp.getWriter()).thenReturn(writer);

		categoriesServlet.doGet(req, resp);

		verify(req).setAttribute("quote", quote);
		verify(req).setAttribute(eq("categories"), anyListOf(Category.class));
	}

}
