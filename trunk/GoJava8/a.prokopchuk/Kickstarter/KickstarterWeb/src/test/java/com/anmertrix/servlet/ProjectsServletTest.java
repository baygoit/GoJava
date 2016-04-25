package com.anmertrix.servlet;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
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
import com.anmertrix.dao.PaymentDao;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Category;
import com.anmertrix.servlet.ProjectsServlet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;

@RunWith(MockitoJUnitRunner.class)
public class ProjectsServletTest {

	@Mock
	private CategoryDao categoryDao;
	@Mock
	private ProjectDao projectDao;
	@Mock
	private PaymentDao paymentDao;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@Mock
	private RequestDispatcher dispatcher;
	@Mock
	private ServletContext context;
	@Mock
	private Category category;
	@InjectMocks
	private ProjectsServlet projectsPage = spy(ProjectsServlet.class);
	@Test
	public void testDoGet() throws ServletException, IOException {
		when(request.getParameter("categoryId")).thenReturn("3");
		when(categoryDao.getCategory(anyLong())).thenReturn(new Category());
		when(categoryDao.categoryExists(anyLong())).thenReturn(true);
		when(category.getId()).thenReturn(3L);
		when(projectDao.getProjectsByCategoryId(anyLong())).thenReturn(new ArrayList<>());
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		when(paymentDao.getGatheredBudgetByProjectId(anyLong())).thenReturn(3L);
		doReturn(context).when(projectsPage).getServletContext();
		projectsPage.doGet(request, response);

		verify(dispatcher).forward(any(), any());
	}
	
	@Test
	public void testDoGetCategoryId() throws ServletException, IOException {
		when(request.getParameter("categoryId")).thenReturn("noNumber");
		assertThat(projectsPage.getSelectedCategory(request, response), is(nullValue()));
	}
	
	@Test
	public void testDoGetCategory() throws ServletException, IOException {
		when(request.getParameter("categoryId")).thenReturn("3");
		when(categoryDao.categoryExists(anyLong())).thenReturn(false);
		projectsPage.doGet(request, response);
		assertThat(projectsPage.getSelectedCategory(request, response), is(nullValue()));
	}
	
	@Test
	public void testDoGetCategoryNotFound() throws ServletException, IOException {
		when(request.getParameter("categoryId")).thenReturn("34");
		when(categoryDao.categoryExists(anyLong())).thenReturn(false);
		projectsPage.getSelectedCategory(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_NOT_FOUND);
	}
}
