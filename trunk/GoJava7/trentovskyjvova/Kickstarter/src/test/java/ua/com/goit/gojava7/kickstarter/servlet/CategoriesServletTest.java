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

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
	@Ignore
	public void testInit() throws ServletException, IOException {

		ServletConfig config = mock(ServletConfig.class);
		ServletContext context = mock(ServletContext.class);
		WebApplicationContext applicationContext = mock(WebApplicationContext.class);
		
		when(config.getServletContext()).thenReturn(context);
		when(WebApplicationContextUtils.getWebApplicationContext(context)).thenReturn(applicationContext);
		
		CategoriesServlet spy = Mockito.spy(categoriesServlet);
		Mockito.doNothing().when(spy).init(config);
		
		categoriesServlet.init(config);
		
		verify(applicationContext).getBean(DaoProvider.class);	
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
