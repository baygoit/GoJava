package com.anmertrix.servlet;

import static org.mockito.Matchers.any;
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

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Quote;

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
	
	@InjectMocks
	private CategoriesServlet categoriesServlet = spy(CategoriesServlet.class);
	
	@Test
	public void testDoGet() throws ServletException, IOException {
		
		when(quoteDao.getRandomQuote()).thenReturn(new Quote());

		when(categoryDao.getCategories()).thenReturn(new ArrayList<>());

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);

		ServletContext context = mock(ServletContext.class);
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);

		doReturn(context).when(categoriesServlet).getServletContext();

		categoriesServlet.doGet(request, response);

		verify(dispatcher).forward(any(), any());

	}

}
