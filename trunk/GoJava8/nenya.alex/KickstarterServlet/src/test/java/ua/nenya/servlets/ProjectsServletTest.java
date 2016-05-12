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
import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Project;

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
	private ProjectsServlet projectsServlet = spy(ProjectsServlet.class);
	
	
	@Test
	public void testDoGetIdIsValidCategoryExists() throws ServletException, IOException {
		when(request.getParameter("categoryId")).thenReturn("1");
		when(categoryDao.isCategoryExist(1L)).thenReturn(true);
		when(projectDao.getProjectsByCategoryId(1L)).thenReturn(new ArrayList<Project>());


		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(projectsServlet).getServletContext();

		projectsServlet.doGet(request, response);
		verify(dispatcher).forward(request, response);
	}
	@Test
	public void testDoGetIdIsInvalidCategoryExists() throws ServletException, IOException {
		when(request.getParameter("categoryId")).thenReturn("invalid");
		when(categoryDao.isCategoryExist(1L)).thenReturn(true);
		when(projectDao.getProjectsByCategoryId(1L)).thenReturn(new ArrayList<Project>());


		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(projectsServlet).getServletContext();

		projectsServlet.doGet(request, response);
	}
	
	@Test
	public void testDoGetCategoryDoesntExist() throws ServletException, IOException {
		when(request.getParameter("categoryId")).thenReturn("1");
		when(categoryDao.isCategoryExist(1L)).thenReturn(false);
		when(projectDao.getProjectsByCategoryId(1L)).thenReturn(new ArrayList<Project>());
		
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(projectsServlet).getServletContext();

		projectsServlet.doGet(request, response);
	}

}
