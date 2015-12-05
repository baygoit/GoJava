package ua.com.goit.gojava7.kickstarter.servlet;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesServletTest {

	@Mock
	private QuoteDao quoteDao;
	@Mock
	private CategoryDao categoryDao;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@Mock
	private PrintWriter writer;
	
	@InjectMocks
	private CategoriesServlet categoriesServlet;
	
	@Test
	public void testDoGet() throws IOException, ServletException {
		
		Quote quote = new Quote();
		quote.setText("TestQuote");
		quote.setAuthor("TestAuthor");
		
		Category category = new Category();
		category.setName("TestCategory");

		List<Category> categories = new ArrayList<>();
		categories.add(category);
		
		when(quoteDao.get(1)).thenReturn(quote);	
		when(categoryDao.getAll()).thenReturn(categories);
		when(response.getWriter()).thenReturn(writer);
		
		//categoriesServlet.doGet(request, response);
	//	verify(writer).append(contains("TestQuote"));
		//verify(writer).append(contains("TestCategory"));
	}
}
