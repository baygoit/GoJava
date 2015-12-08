package ua.com.goit.gojava7.kickstarter.servlet;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
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
	public void testInit() throws ServletException, IOException {
		
		DaoProvider daoProvider = mock(DaoProvider.class);
		ServletConfig config = mock(ServletConfig.class);
		ServletContext context = mock(ServletContext.class);
		
		when(config.getServletContext()).thenReturn(context);
		when(context.getAttribute(ContextListener.STORAGE_FACTORY)).thenReturn(daoProvider);

		categoriesServlet.init(config);

		verify(daoProvider).getQuoteReader();
		verify(daoProvider).getCategoryReader();
	}
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		
		Quote quote = new Quote("quote text", "quote author");
		when(quoteDao.getRandomQuote()).thenReturn(quote);
		
		List<Category> categories = new ArrayList<>();
		Category category = new Category();
		category.setName("categ name");
		categories.add(category);
		when(categoryDao.getCategories()).thenReturn(categories);
				
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(req.getRequestDispatcher(contains("categories"))).thenReturn(rd);
		
		categoriesServlet.doGet(req, resp);
		
		verify(req).setAttribute("quote", quote);
		verify(req).setAttribute("categories", categories);
		verify(rd).forward(req, resp);

	}

}
