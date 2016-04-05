package com.anmertrix.page;

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
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Category;

@RunWith(MockitoJUnitRunner.class)
public class ProjectsPageTest {

	@Mock
	private CategoryDao categoryDao;
	@Mock
	private ProjectDao projectDao;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@InjectMocks
	private ProjectsPage projectsPage = spy(ProjectsPage.class);
	
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

}
