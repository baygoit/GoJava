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
import com.anmertrix.dao.NoResultException;
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
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@InjectMocks
	private ProjectsServlet projectsPage = spy(ProjectsServlet.class);
	
	@Test
	public void testDoGet() throws ServletException, IOException {
		when(request.getParameter("categoryId")).thenReturn("3");

		when(categoryDao.getCategory(3)).thenReturn(new Category());

		when(projectDao.getProjectsByCategoryId(3)).thenReturn(new ArrayList<>());

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);

		ServletContext context = mock(ServletContext.class);
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);

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
		when(request.getParameter("categoryId")).thenReturn("123");
		when(categoryDao.getCategory(123)).thenThrow(new NoResultException("No category found"));
		assertThat(projectsPage.getSelectedCategory(request, response), is(nullValue()));
	}

	
	
}
