package ua.com.goit.gojava7.kikstarter.controller.servlet;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kikstarter.domain.Category;
import ua.com.goit.gojava7.kikstarter.domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class SelectionCategoriesTest {

	@Mock
	private QuoteDao quoteDao;

	@Mock
	private CategoryDao categoryDao;

	@Mock
	private RequestDispatcher dispatcher;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private ServletConfig config;

	@InjectMocks
	private SelectoinCategories servlet;

	@Before
	public void setUp() throws Exception {
		Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(dispatcher);
	}
	
//	@Test
//	public void testInit() throws Exception{
//		servlet.init();
//		
////		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(anyObject());
//	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, Exception {
		Quote quote = new Quote("content", "author");
		Mockito.when(quoteDao.getRandomQuote()).thenReturn(quote);

		ArrayList<Category> categories = new ArrayList<>();
		Category cat1=new Category();
		cat1.setId(1);
		cat1.setName("cat1");
		Category cat2=new Category();
		cat2.setId(2);
		cat2.setName("cat2");
		categories.add(cat1);
		categories.add(cat2);
		Mockito.when(categoryDao.getAll()).thenReturn(categories);

		servlet.doGet(request, response);
		Mockito.verify(request).getRequestDispatcher("WEB-INF/jsp/categories.jsp");
		Mockito.verify(request).setAttribute("content", quote.getContent());
		Mockito.verify(request).setAttribute("author", quote.getAuthor());
		Mockito.verify(request).setAttribute("categories", categories);
		Mockito.verify(dispatcher).forward(request, response);
	}

}
