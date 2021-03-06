package ua.nenya.servlets;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Category;
import ua.nenya.domain.Quote;


@RunWith(MockitoJUnitRunner.class)
public class CategoryServletTest {

	@Mock
	private CategoryDao categoryDao;
	@Mock
	private QuoteDao quoteDao;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@InjectMocks
	private CategoryServlet categoryServlet = spy(CategoryServlet.class);
	
	@Test
	public void testDoGet() throws ServletException, IOException {
		when(quoteDao.getRandomQuote()).thenReturn(new Quote());
		when(categoryDao.getCategories()).thenReturn(new ArrayList<Category>());
		
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(categoryServlet).getServletContext();
		
		categoryServlet.doGet(request, response);
		verify(dispatcher).forward( request, response);

	}

}
